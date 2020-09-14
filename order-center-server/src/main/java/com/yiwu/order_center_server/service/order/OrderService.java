package com.yiwu.order_center_server.service.order;

import com.yiwu.order_center_client.order.domain.Order;
import com.yiwu.order_center_server.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: fuzf
 * @Date: 2020/9/14 11:40
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Long addOrder(Order order) {
        orderDao.insertOrder(order);
        return order.getId();
    }

    public Order findOrderById(Long id) {
        return orderDao.selectOrderById(id);
    }

    public Order findOrderByOrderNo(String orderNo) {
        return orderDao.selectOrderByOrderNo(orderNo);
    }

}
