package com.github.bxy.authority.config.mq;

import com.alibaba.fastjson.JSONObject;
import com.github.bxy.authority.dto.auth.SystemApiScanSaveDTO;
import com.github.bxy.authority.service.auth.SystemApiService;
import com.github.bxy.common.constant.QueueConstants;
import com.github.bxy.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * 消息队列配置
 *
 * @author bxy
 * @date 2019/12/17
 */
@Configuration
@Slf4j
@ConditionalOnProperty(prefix = "bxy.rabbitmq", name = "enabled", havingValue = "true")
public class AuthorityMqAutoConfiguration {
    @Value("${bxy.mysql.biz-database:bxy_default}")
    private String databaseName;
    @Autowired
    private SystemApiService systemApiService;

    @Bean
    public Queue apiResourceQueue() {
        Queue queue = new Queue(QueueConstants.QUEUE_SCAN_API_RESOURCE);
        log.info("Query {} [{}]", QueueConstants.QUEUE_SCAN_API_RESOURCE, queue);
        return queue;
    }

    @RabbitListener(queues = QueueConstants.QUEUE_SCAN_API_RESOURCE)
    public void ScanApiResourceQueue(@Payload String param) {
        SystemApiScanSaveDTO scan = JSONObject.parseObject(param, SystemApiScanSaveDTO.class);
        BaseContextHandler.setTenant(scan.getTenant());
        BaseContextHandler.setDatabase(this.databaseName);

        this.systemApiService.batchSave(scan);
    }
}
