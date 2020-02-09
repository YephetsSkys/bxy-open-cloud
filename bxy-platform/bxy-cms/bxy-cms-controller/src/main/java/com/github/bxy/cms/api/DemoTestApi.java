package com.github.bxy.cms.api;

import com.github.bxy.authority.entity.core.Org;
import com.github.bxy.base.R;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * This is a Description
 *
 * @author bxy
 * @date 2019/08/12
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-cms-server}", path = "/seata")
public interface DemoTestApi {
    /**
     * 新增时发生异常
     *
     * @param data
     * @return
     */
    @PostMapping("/saveEx")
    R<Org> saveEx(@RequestBody Org data);

    /**
     * 新增
     *
     * @param data
     * @return
     */
    @PostMapping("/save")
    R<Org> save(@RequestBody Org data);
}
