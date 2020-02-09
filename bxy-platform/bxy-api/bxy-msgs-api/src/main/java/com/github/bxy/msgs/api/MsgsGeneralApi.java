package com.github.bxy.msgs.api;

import java.util.Map;

import com.github.bxy.base.R;
import com.github.bxy.msgs.api.fallback.MsgsGeneralApiFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通用API
 *
 * @author bxy
 * @date 2019/07/26
 */
@FeignClient(name = "${bxy.feign.msgs-server:bxy-msgs-server}", fallback = MsgsGeneralApiFallback.class)
public interface MsgsGeneralApi {
    /**
     * 查询系统中常用的枚举类型等
     *
     * @return
     */
    @GetMapping("/enums")
    R<Map<String, Map<String, String>>> enums();
}
