package com.github.bxy.zuul.config.zipkin;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OkHttpClient集成Trace跟踪的自动化配置部分
 *
 * @author bxy
 * @date 2019-12-09 17:23
 */
@Configuration
@ConditionalOnProperty(name = "bxy.zipkin.enabled", havingValue = "true")
public class OkHttpTraceAutoConfig {

    /**
     * 如果还未定义OkHttpClient的bean，则采用此OkHttpClient
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(OkHttpClient.class)
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(20, 10L, TimeUnit.SECONDS))
                .build();
    }

    @Bean
    public OkhttpTraceInterceptor okhttpTraceInterceptor() {
        return new OkhttpTraceInterceptor();
    }

    @Bean
    public OkHttpTracePostProcessor okHttpTracePostProcessor() {
        return new OkHttpTracePostProcessor(okhttpTraceInterceptor());
    }
}
