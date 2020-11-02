package com.yiwu.order_center_server.common.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yiwu.order_center_server.common.rabbitmq.ConnectUtils;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 10:59
 */
public class SendTest {

    private static final String QUEUE_NAME = "test-queue";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectUtils.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消息内容
        String message = "Hello RabbitMq!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
