package com.yiwu.order_center_server.common.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 14:47
 */
@Component
@RabbitListener(queues = "test-queue")
public class HelloGet {

    @RabbitHandler
    public void process(String string) {
        System.out.println("Receiver  : " + string);
    }

}
