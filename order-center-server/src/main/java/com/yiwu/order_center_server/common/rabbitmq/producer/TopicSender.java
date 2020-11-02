package com.yiwu.order_center_server.common.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 18:08
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1(String str) {
        String context = "hi, i am message 1; order:" + str;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("mytopicexchange", "topic.message", context);
    }


    public void send2(String str) {
        String context = "hi, i am messages 2; order:" + str;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("mytopicexchange", "topic.messages", context);
    }

}
