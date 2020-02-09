package com.github.bxy.cms.config;

import com.github.bxy.authority.api.LogApi;
import com.github.bxy.common.config.BaseConfig;
import com.github.bxy.log.event.SysLogListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bxy
 * @createTime 2017-12-15 14:42
 */
@Configuration
public class CmsWebConfiguration extends BaseConfig {
    @Value("${bxy.mysql.biz-database:bxy_defaults}")
    private String database;

    @Bean
    public SysLogListener sysLogListener(LogApi logApi) {
        return new SysLogListener(this.database, (log) -> logApi.save(log));
    }
}
