package com.yiwu.order_center_server.common.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 14:39
 */
@Component
public class HelloSender {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String simpleString) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello " + date+", "+simpleString;
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
        this.rabbitTemplate.convertAndSend("test-queue", context);
    }

}
