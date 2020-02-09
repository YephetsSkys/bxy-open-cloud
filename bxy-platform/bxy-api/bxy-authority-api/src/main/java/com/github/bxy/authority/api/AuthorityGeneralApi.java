package com.github.bxy.authority.api;

import java.util.Map;

import com.github.bxy.authority.api.hystrix.AuthorityGeneralApiFallback;
import com.github.bxy.base.R;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通用API
 *
 * @author bxy
 * @date 2019/07/26
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-authority-server}", fallback = AuthorityGeneralApiFallback.class)
public interface AuthorityGeneralApi {
    /**
     * 查询系统中常用的枚举类型等
     *
     * @return
     */
    @GetMapping("/enums")
    R<Map<String, Map<String, String>>> enums();
}
