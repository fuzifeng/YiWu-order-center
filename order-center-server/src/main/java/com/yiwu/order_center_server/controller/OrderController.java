package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_client.order.domain.Order;
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

    @PostMapping("/createOrder")
    public Resp<Long> order(@RequestBody Order order) {
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        Long orderId = orderService.addOrder(order);
        return Resp.success(orderId);
    }

    @GetMapping("/findOrderByOrderNo")
    public Resp<Order> findOrderInfoByOrderNo(@RequestParam String orderNo) {
        Order order = orderService.findOrderByOrderNo(orderNo);
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
