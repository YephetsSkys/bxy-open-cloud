package com.github.bxy.authority.config;

import com.github.bxy.authority.service.common.OptLogService;
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
public class AuthorityWebConfiguration extends BaseConfig {
    @Value("${bxy.mysql.biz-database:bxy_defaults}")
    private String database;

    @Bean
    public SysLogListener sysLogListener(OptLogService optLogService) {
        return new SysLogListener(this.database, (log) -> optLogService.save(log));
    }
}
