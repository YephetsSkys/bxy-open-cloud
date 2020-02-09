package com.github.bxy.authority.api.hystrix;

import com.github.bxy.authority.api.LogApi;
import com.github.bxy.base.R;
import com.github.bxy.log.entity.OptLogDTO;

import org.springframework.stereotype.Component;

/**
 * 日志操作 熔断
 *
 * @author bxy
 * @date 2019/07/02
 */
@Component
public class LogApiHystrix implements LogApi {
    @Override
    public R<OptLogDTO> save(OptLogDTO log) {
        return R.timeout();
    }
}
