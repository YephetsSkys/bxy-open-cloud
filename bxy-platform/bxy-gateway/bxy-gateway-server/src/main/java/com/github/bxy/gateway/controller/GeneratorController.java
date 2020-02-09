package com.github.bxy.gateway.controller;

import cn.hutool.core.util.StrUtil;
import com.github.bxy.authority.api.AuthorityGeneralApi;
import com.github.bxy.authority.api.DictionaryItemApi;
import com.github.bxy.base.R;
import com.github.bxy.common.constant.DictionaryCode;
import com.github.bxy.context.BaseContextConstants;
import com.github.bxy.context.BaseContextHandler;
import com.github.bxy.file.api.FileGeneralApi;
import com.github.bxy.msgs.api.MsgsGeneralApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.result.view.Rendering;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 常用Controller
 *
 * @author bxy
 * @date 2019-06-21 18:22
 */
@Controller
public class GeneratorController {

    @Resource
    private AuthorityGeneralApi authorityGeneralApi;
    @Resource
    private FileGeneralApi fileGeneralApi;
    @Resource
    private MsgsGeneralApi msgsGeneralApi;
    @Resource
    private DictionaryItemApi dictionaryItemApi;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    /**
     * 解决swagger-bootstrap-ui的一个bug
     * <p>
     * 有个前提： nginx的端口要和访问端口一致，否则重定向出错
     *
     * @param service 服务
     * @param group   组
     * @param ext     uri 后缀
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取指定服务的swagger", notes = "获取当前系统所有数据字典和枚举")
    @GetMapping("${server.servlet.context-path:}/{service}/v2/{ext}")
    @Deprecated
    public Rendering apiDocs(@PathVariable String service, @PathVariable String ext, String group) throws Exception {
        if (group == null) {
            group = "default";
        }
        String newGroup = group;
        if (group.contains("-")) {
            newGroup = StrUtil.subSuf(group, group.indexOf("-") + 1);
        }

        String uri = String.format("%s/%s/v2/%s?group=%s", contextPath, service, ext, URLEncoder.encode(newGroup, "UTF-8"));
        return Rendering.redirectTo(uri).build();
    }

    /**
     * 兼容zuul
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/gate/doc.html")
    public Rendering doc() throws Exception {
        String uri = String.format("%s/doc.html", contextPath);
        return Rendering.redirectTo(uri).build();
    }


    /**
     * 获取当前系统所有数据字典和枚举
     *
     * @return
     */
    @ApiOperation(value = "获取当前系统所有数据字典和枚举", notes = "获取当前系统所有数据字典和枚举")
    @GetMapping("/gate/dictionary/enums")
    @ResponseBody
    public Mono<R<Map<String, Map<String, String>>>> dictionaryAndEnum(ServerWebExchange exchange) {
        List<String> tenants = exchange.getRequest().getHeaders().get(BaseContextConstants.TENANT);

        if (tenants != null && !tenants.isEmpty()) {
            BaseContextHandler.setTenant(tenants.get(0));
        }

        Map<String, Map<String, String>> map = new HashMap<>(4);

        map.putAll(enums());

        //整个系统的数据字典
        R<Map<String, Map<String, String>>> itemMap = dictionaryItemApi.map(DictionaryCode.ALL);
        if (itemMap.getIsSuccess()) {
            map.putAll(itemMap.getData());
        }

        return Mono.just(R.success(map));
    }

    private Map enums() {
        Map<String, Map<String, String>> map = new HashMap<>(3);
        //权限服务的枚举
        R<Map<String, Map<String, String>>> authorityResult = authorityGeneralApi.enums();
        if (authorityResult.getIsSuccess()) {
            map.putAll(authorityResult.getData());
        }

        //文件服务的枚举
        R<Map<String, Map<String, String>>> fileResult = fileGeneralApi.enums();
        if (fileResult.getIsSuccess()) {
            map.putAll(fileResult.getData());
        }

        R<Map<String, Map<String, String>>> msgsResult = msgsGeneralApi.enums();
        if (msgsResult.getIsSuccess()) {
            map.putAll(msgsResult.getData());
        }
        return map;
    }

    /**
     * 获取当前系统所有数据字典和枚举
     *
     * @return
     */
    @ApiOperation(value = "获取当前系统所有枚举", notes = "获取当前系统所有枚举")
    @GetMapping("/gate/enums")
    @ResponseBody
    public Mono<R<Map<String, Map<String, String>>>> allEnums() {
        return Mono.just(R.success(enums()));
    }
}
