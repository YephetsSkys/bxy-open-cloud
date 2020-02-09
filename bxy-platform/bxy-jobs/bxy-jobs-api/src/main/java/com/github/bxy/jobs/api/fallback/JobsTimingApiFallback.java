package com.github.bxy.jobs.api.fallback;

import com.github.bxy.base.R;
import com.github.bxy.jobs.api.JobsTimingApi;
import com.github.bxy.jobs.dto.XxlJobInfo;

import org.springframework.stereotype.Component;

/**
 * 定时API 熔断
 *
 * @author bxy
 * @date 2019/07/16
 */
@Component
public class JobsTimingApiFallback implements JobsTimingApi {
    @Override
    public R<String> addTimingTask(XxlJobInfo xxlJobInfo) {
        return R.timeout();
    }
}
