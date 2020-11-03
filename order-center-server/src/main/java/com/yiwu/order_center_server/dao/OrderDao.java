package com.yiwu.order_center_server.dao;

import com.yiwu.order_center_client.order.domain.Order;
import com.yiwu.order_center_server.dto.OrderDto;

/**
 * @Author: fuzf
 * @Date: 2020/9/14 11:26
 */
public interface OrderDao {

    int insertOrder(Order order);

    Order selectOrderByOrderNo(String orderNo);

    Order selectOrderById(Long id);

    OrderDto selectOrderDtoById(Long id);
}
