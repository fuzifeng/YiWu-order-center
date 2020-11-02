package com.yiwu.order_center_server.common.rabbitmq.consumer;

import com.rabbitmq.client.*;
import com.yiwu.order_center_server.common.rabbitmq.ConnectUtils;

import java.io.IOException;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 11:31
 */
public class GetTest {
    private static final String QUEUE_NAME = "test-queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicConsume(QUEUE_NAME,false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者："+new java.lang.String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

        //定义队列的消费者
//        QueueingConsumer  consumer = new QueueingConsumer(channel);
//        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(consumerTag);
//                System.out.println(envelope.toString());
//                System.out.println(properties.toString());
//                System.out.println("消息内容:" + new String(body));
//            }
//        };
//
//        defaultConsumer.handleCancelOk("ok");

    }
}
