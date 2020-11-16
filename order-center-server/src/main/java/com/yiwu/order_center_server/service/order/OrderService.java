package com.yiwu.order_center_server.service.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiwu.order_center_client.order.domain.Order;
import com.yiwu.order_center_server.dao.OrderDao;
import com.yiwu.order_center_server.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public OrderDto findOrderDtoById(Long id) {
        return orderDao.selectOrderDtoById(id);
    }

    public PageInfo<Order> orderList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list = orderDao.selectByParams();
        return new PageInfo(list);

    }
}
