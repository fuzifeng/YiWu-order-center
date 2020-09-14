package com.yiwu.order_center_client.order.api;

import com.yiwu.order_center_client.order.domain.Order;

/**
 * @Author: fuzf
 * @Date: 2020/9/10 15:24
 */
public interface OrderInterface {
    Order findById();
}
