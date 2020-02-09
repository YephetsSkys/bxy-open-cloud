package com.github.bxy.authority.api;

import com.github.bxy.authority.api.hystrix.LogApiHystrix;
import com.github.bxy.base.R;
import com.github.bxy.log.entity.OptLogDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 操作日志保存 API
 *
 * @author bxy
 * @date 2019/07/02
 */
@FeignClient(name = "${bxy.feign.authority-server:bxy-authority-server}", fallback = LogApiHystrix.class)
public interface LogApi {
    /**
     * 保存日志
     *
     * @param log 日志
     * @return
     */
    @RequestMapping(value = "/optLog", method = RequestMethod.POST)
    R<OptLogDTO> save(@RequestBody OptLogDTO log);

}
