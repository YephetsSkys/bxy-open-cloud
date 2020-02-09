package com.github.bxy.authority.api;

import java.util.List;

import com.github.bxy.authority.api.hystrix.RoleApiFallback;
import com.github.bxy.base.R;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 角色API
 *
 * @author bxy
 * @date 2019/08/02
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-authority-server}", path = "/role", fallback = RoleApiFallback.class)
public interface RoleApi {
    /**
     * 根据角色编码，查找用户id
     *
     * @param codes 角色编码
     * @return
     */
    @GetMapping("/codes")
    R<List<Long>> findUserIdByCode(@RequestParam(value = "codes") String[] codes);
}
