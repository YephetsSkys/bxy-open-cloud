package com.github.bxy.gateway.filter;

import java.util.List;

import com.github.bxy.auth.client.properties.AuthClientProperties;
import com.github.bxy.auth.client.utils.JwtTokenClientUtils;
import com.github.bxy.auth.utils.JwtUserInfo;
import com.github.bxy.base.R;
import com.github.bxy.common.adapter.IgnoreTokenConfig;
import com.github.bxy.context.BaseContextConstants;
import com.github.bxy.exception.BizException;
import com.github.bxy.utils.StrHelper;
import com.github.bxy.utils.StrPool;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 过滤器
 *
 * @author bxy
 * @date 2019/07/31
 */
@Component
@Slf4j
//@Order(0)
public class AccessFilter implements GlobalFilter {
    @Value("${spring.profiles.active:dev}")
    protected String profiles;
    @Autowired
    private AuthClientProperties authClientProperties;
    @Autowired
    private JwtTokenClientUtils jwtTokenClientUtils;

    protected boolean isDev() {
        return !StrPool.PROD.equalsIgnoreCase(profiles);
    }

    /**
     * 忽略应用级token
     *
     * @return
     */
    protected boolean isIgnoreToken(String uri) {
        return IgnoreTokenConfig.isIgnoreToken(uri);
    }

    protected String getTokenFromRequest(String headerName, ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        String token = StrUtil.EMPTY;
        if (headers == null || headers.isEmpty()) {
            return token;
        }

        List<String> headerList = headers.get(headerName);
        if (headerList == null || headerList.isEmpty()) {
            return token;
        }
        token = headerList.get(0);

        if (StringUtils.isNotBlank(token)) {
            return token;
        }
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        if (queryParams == null || queryParams.isEmpty()) {
            return token;
        }
        return queryParams.getFirst(headerName);
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 不进行拦截的地址
        if (isIgnoreToken(request.getPath().toString())) {
            log.debug("access filter not execute");
            return chain.filter(exchange);
        }

        //获取token， 解析，然后想信息放入 heade
        //1, 获取token

        String userToken = getTokenFromRequest(authClientProperties.getUser().getHeaderName(), request);

        //2, 解析token
        JwtUserInfo userInfo = null;

        //添加测试环境的特殊token
        if (isDev() && StrPool.TEST.equalsIgnoreCase(userToken)) {
            userInfo = new JwtUserInfo(1L, "bxy", "最后", 1L, 1L);
        }
        try {
            if (userInfo == null) {
                userInfo = jwtTokenClientUtils.getUserInfo(userToken);
            }
        } catch (BizException e) {
            return errorResponse(response, e.getMessage(), e.getCode(), 200);
        } catch (Exception e) {
            return errorResponse(response, "验证token出错", R.FAIL_CODE, 200);
        }

        ServerHttpRequest.Builder mutate = request.mutate();

        //3, 将信息放入header
        if (userInfo != null) {
            addHeader(mutate, BaseContextConstants.JWT_KEY_ACCOUNT, userInfo.getAccount());
            addHeader(mutate, BaseContextConstants.JWT_KEY_USER_ID, userInfo.getUserId());
            addHeader(mutate, BaseContextConstants.JWT_KEY_NAME, userInfo.getName());

            addHeader(mutate, BaseContextConstants.JWT_KEY_ORG_ID, userInfo.getOrgId());
            addHeader(mutate, BaseContextConstants.JWT_KEY_STATION_ID, userInfo.getStationId());
        }

        ServerHttpRequest build = mutate.build();
        return chain.filter(exchange.mutate().request(build).build());
    }

    private void addHeader(ServerHttpRequest.Builder mutate, String name, Object value) {
        if (org.springframework.util.StringUtils.isEmpty(value)) {
            return;
        }
        String valueStr = value.toString();
        String valueEncode = StrHelper.encode(valueStr);
        mutate.header(name, valueEncode);
    }

    protected Mono<Void> errorResponse(ServerHttpResponse response, String errMsg, int errCode, int httpStatusCode) {
        R tokenError = R.fail(errCode, errMsg);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        DataBuffer dataBuffer = response.bufferFactory().wrap(tokenError.toString().getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }

}
