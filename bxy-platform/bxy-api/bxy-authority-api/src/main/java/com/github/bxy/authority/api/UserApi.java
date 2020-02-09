package com.github.bxy.authority.api;

import com.github.bxy.authority.api.hystrix.UserApiFallback;
import com.github.bxy.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author bxy
 * @date 2019/07/02
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-authority-server}", fallback = UserApiFallback.class, path = "/user")
public interface UserApi {
    /**
     * 刷新token
     *
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/ds/{id}", method = RequestMethod.GET)
    Map<String, Object> getDataScopeById(@PathVariable("id") Long id);

    /**
     * 查询所有的用户id
     *
     * @return
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    R<List<Long>> findAllUserId();
}
