package com.yiwu.order_center_server.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 14:15
 */

@Configuration
public class RabbitConfig {

    private static final String QUEUE_TEST_NAME = "test-queue";

    public static final String DELAY_EXCHANGE = "delay_exchange";
    public static final String DELAY_QUEUE_NAME = "delay_queue_name";
    public static final String DELAY_ROUTING_KEY = "delay_routing_key";

    @Bean("testQueue")
    public Queue testQueue() {
        return new Queue(QUEUE_TEST_NAME,true);
    }

    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE, "x-delayed-message", true, false, maps);
    }

    @Bean
    public Queue queue() {
        return new Queue(DELAY_QUEUE_NAME, true);
    }

    @Bean
    public Binding binding(Queue queue, CustomExchange customExchange) {
        return BindingBuilder.bind(queue).to(customExchange).with(DELAY_ROUTING_KEY).noargs();
    }
}
