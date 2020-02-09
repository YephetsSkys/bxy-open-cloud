package com.github.bxy.file.api;

import java.util.Map;

import com.github.bxy.base.R;
import com.github.bxy.file.api.fallback.FileGeneralApiFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通用API
 *
 * @author bxy
 * @date 2019/07/26
 */
@FeignClient(name = "${bxy.feign.file-server:bxy-file-server}", fallback = FileGeneralApiFallback.class)
public interface FileGeneralApi {
    /**
     * 查询系统中常用的枚举类型等
     *
     * @return
     */
    @GetMapping("/enums")
    R<Map<String, Map<String, String>>> enums();
}
