package com.github.bxy.demo.config.datasource;


import com.github.bxy.authority.api.UserApi;
import com.github.bxy.database.datasource.BaseMybatisConfiguration;
import com.github.bxy.database.mybatis.auth.DataScopeInterceptor;
import com.github.bxy.database.properties.DatabaseProperties;
import com.github.bxy.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置一些拦截器
 *
 * @author bxy
 * @createTime 2017-11-18 0:34
 */
@Configuration
@Slf4j
public class DemoMybatisAutoConfiguration extends BaseMybatisConfiguration {


    public DemoMybatisAutoConfiguration(DatabaseProperties databaseProperties) {
        super(databaseProperties);

    }

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
    @Bean
    @ConditionalOnProperty(name = "bxy.database.isDataScope", havingValue = "true", matchIfMissing = true)
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor((userId) -> SpringUtils.getBean(UserApi.class).getDataScopeById(userId));
    }

}
