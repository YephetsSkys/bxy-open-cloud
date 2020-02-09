package com.github.bxy.authority.api;

import java.util.Map;

import com.github.bxy.authority.api.hystrix.DictionaryItemApiFallback;
import com.github.bxy.base.R;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 数据字典API
 *
 * @author bxy
 * @date 2019/07/26
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-authority-server}", fallback = DictionaryItemApiFallback.class)
public interface DictionaryItemApi {

    /**
     * 根据字典编码查询字典条目的map集合
     *
     * @param codes
     * @return
     */
    @GetMapping("/dictionaryItem/codes")
    R<Map<String, Map<String, String>>> map(@RequestParam("codes") String[] codes);
}
