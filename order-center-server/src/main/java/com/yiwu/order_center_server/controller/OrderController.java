package com.yiwu.order_center_server.controller;

import com.google.gson.Gson;
import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_client.order.domain.Order;
import com.yiwu.order_center_server.common.rabbitmq.producer.HelloSender;
import com.yiwu.order_center_server.common.rabbitmq.producer.TopicSender;
import com.yiwu.order_center_server.dto.OrderDto;
import com.yiwu.order_center_server.exception.BusinessException;
import com.yiwu.order_center_server.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: fuzf
 * @Date: 2020/9/10 15:37
 */
@RestController
@RequestMapping("/web/order-center/order")
public class OrderController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    HelloSender helloSender;
    @Autowired
    TopicSender topicSender;


    @PostMapping("/createOrder")
    public Resp<Long> order(@RequestBody Order order) {
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setTotalMoney(12340000L);
        Long orderId = orderService.addOrder(order);
//        String orderStr = new Gson().toJson(order);
//        helloSender.send(orderStr);
//        topicSender.send1(orderStr);
//        topicSender.send2(orderStr);

        return Resp.success(orderId);
    }

    @GetMapping("/findOrderByOrderNo")
    public Resp<Order> findOrderInfoByOrderNo(@RequestParam String orderNo) {
        Order order = orderService.findOrderByOrderNo(orderNo);
        return Resp.success(order);
    }

    @GetMapping("/findOrderById")
    public Resp<OrderDto> findOrderInfoByOrderNo(@RequestParam Long id) {
        OrderDto order = orderService.findOrderDtoById(id);
        return Resp.success(order);
    }





    @GetMapping("/test")
    public Resp errorTest() {
        log.error("sasasaa");
        int i = 0;
        int j = 1;
        try {
            int k = j / i;
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {

            throw new BusinessException(1, e.getMessage());
        }
        return Resp.success();
    }

}
