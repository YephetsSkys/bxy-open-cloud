package com.github.bxy.datasource;


import com.github.bxy.database.datasource.BaseMybatisConfiguration;
import com.github.bxy.database.properties.DatabaseProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * 配置一些拦截器
 *
 * @author bxy
 * @createTime 2017-11-18 0:34
 */
@Configuration
@Slf4j
public class JobsMybatisAutoConfiguration extends BaseMybatisConfiguration {


    public JobsMybatisAutoConfiguration(DatabaseProperties databaseProperties) {
        super(databaseProperties);

    }

//    /**
//     * 数据权限插件
//     *
//     * @return DataScopeInterceptor
//     */
//    @Bean
//    @ConditionalOnProperty(name = "bxy.database.isDataScope", havingValue = "true", matchIfMissing = true)
//    public DataScopeInterceptor dataScopeInterceptor() {
//        return new DataScopeInterceptor((userId) -> SpringUtils.getBean(UserService.class).getDataScopeById(userId));
//    }

}
