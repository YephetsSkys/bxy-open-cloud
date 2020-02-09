//package com.github.bxy.cms.config.datasource;
//
//
//import cn.hutool.core.util.ArrayUtil;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import com.github.bxy.authority.api.UserApi;
//import com.github.bxy.database.datasource.BaseDbConfiguration;
//import com.github.bxy.database.mybatis.auth.DataScopeInterceptor;
//import com.github.bxy.utils.SpringUtils;
//import com.p6spy.engine.spy.P6DataSource;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.aop.Advisor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.interceptor.TransactionInterceptor;
//
//import javax.sql.DataSource;
//
///**
// * bxy 中心数据库配置 附件配置
// *
// * @author bxy
// * @createTime 2017-11-18 0:34
// */
//@Configuration
//@MapperScan(
//        basePackages = {"com.github.bxy.cms.dao"},
//        annotationClass = Repository.class,
//        sqlSessionFactoryRef = "sqlSessionFactory")
//public class OrderDataSourceAutoConfiguration extends BaseDbConfiguration {
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    /**
//     * 数据源信息
//     *
//     * @return
//     */
//    @Bean("ds")
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    public DataSource druid() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "p6ds")
//    public DataSource p6ds(@Qualifier("ds") DataSource dataSource) {
//        if (ArrayUtil.contains(DEV_PROFILES, this.profiles)) {
//            return new P6DataSource(dataSource);
//        } else {
//            return dataSource;
//        }
//    }
//
//    @Bean("dataSourceProxy")
//    public DataSourceProxy dataSourceProxy(@Qualifier("p6ds") DataSource dataSource) {
//        return new DataSourceProxy(dataSource);
//    }
//
//    @Bean(name = "txorder")
//    @Primary
//    public DataSourceTransactionManager orderTransactionManager(@Qualifier("dataSourceProxy") DataSourceProxy dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean("sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("orderGlobalConfig") GlobalConfig globalConfig,
//                                               @Qualifier("myMetaObjectHandler") MetaObjectHandler myMetaObjectHandler,
//                                               @Qualifier("dataSourceProxy") DataSourceProxy dataSource) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        return super.setMybatisSqlSessionFactoryBean(sqlSessionFactory,
//                new String[]{"classpath*:mapper_**/**/*Mapper.xml"},
//                globalConfig, myMetaObjectHandler);
//    }
//
//
//    @Bean("orderTxAdvice")
//    @Primary
//    @Override
//    public TransactionInterceptor txAdvice(@Qualifier("txorder") PlatformTransactionManager transactionManager) {
//        return super.txAdvice(transactionManager);
//    }
//
//    @Bean("orderTxAdviceAdvisor")
//    @Primary
//    @Override
//    public Advisor txAdviceAdvisor(@Qualifier("txorder") PlatformTransactionManager transactionManager) {
//        return super.txAdviceAdvisor(transactionManager);
//    }
//
//    /**
//     * 全局配置
//     *
//     * @return
//     */
//    @Bean("orderGlobalConfig")
//    public GlobalConfig globalConfig() {
//        return this.defGlobalConfig();
//    }
//
//
//    /**
//     * 数据权限插件
//     *
//     * @return DataScopeInterceptor
//     */
//    @Override
//    public DataScopeInterceptor getDataScopeInterceptor() {
//        return new DataScopeInterceptor((userId) -> SpringUtils.getBean(UserApi.class).getDataScopeById(userId));
//    }
//}
