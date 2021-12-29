package com.yiwu.order_center_server.common.rabbitmq.consumer;

import com.google.gson.Gson;
import com.yiwu.order_center_server.config.RabbitConfig;
import com.yiwu.order_center_server.dao.OrderDao;
import com.yiwu.order_center_server.domain.Order;
import com.yiwu.order_center_server.service.order.OrderService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: fuzf
 * @Date: 2020/11/2 18:01
 */
@Component
//@RabbitListener(queues = "order_queue")
public class OrderConsumer {
    @Autowired
    OrderDao orderDao;

    @RabbitHandler
    @RabbitListener(queues = "order_queue")
    public void process(String orderJson) {
        System.out.println("Order receive  : " + orderJson);
        try {
//            Order order = new Gson().fromJson(orderJson, Order.class);
//            Long id = order.getId();
            Order curOrder = orderDao.selectOrderByOrderNo(orderJson);
            if (curOrder == null || curOrder.getStatus() == null || curOrder.getStatus() != 1) {
                System.out.println("OrderId : " + orderJson + " 还没支付");
            } else {
                System.out.println("OrderId : " + orderJson + " 状态是" + curOrder.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitConfig.DELAY_QUEUE_NAME)
    public void receive(String message) {
        System.out.println(new Date());
        System.out.println("delay info : " + message);
    }
}
