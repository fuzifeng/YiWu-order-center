package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.order.domaim.Order;
import com.yiwu.order_center_client.order.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fuzf
 * @Date: 2020/9/10 15:37
 */
@RestController
public class OrderController implements OrderService {
    @Override
    public Order findById() {
        return null;
    }
}
