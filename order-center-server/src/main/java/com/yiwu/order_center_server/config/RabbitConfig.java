package com.yiwu.order_center_server.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 14:15
 */

@Configuration
public class RabbitConfig {

    private static final String QUEUE_TEST_NAME="test-queue";

    @Bean("testQueue")
    public Queue testQueue() {
        return new Queue(QUEUE_TEST_NAME,true);
    }
}
