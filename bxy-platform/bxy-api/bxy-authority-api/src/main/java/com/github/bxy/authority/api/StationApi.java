package com.github.bxy.authority.api;

import com.github.bxy.authority.api.hystrix.StationApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * 岗位API
 *
 * @author bxy
 * @date 2019/08/02
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-authority-server}", path = "/station", fallback = StationApiFallback.class)
public interface StationApi {

    /**
     * 根据id查询 岗位
     *
     * @param ids
     * @return
     */
    @GetMapping("/findStationByIds")
    Map<Serializable, Object> findStationByIds(@RequestParam(value = "ids") Set<Serializable> ids);
}
