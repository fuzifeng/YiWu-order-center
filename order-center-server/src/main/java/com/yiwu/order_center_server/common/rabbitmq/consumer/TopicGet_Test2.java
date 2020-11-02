package com.yiwu.order_center_server.common.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 18:01
 */
@Component
@RabbitListener(queues = "q_topic_message_2")
public class TopicGet_Test2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }
}
