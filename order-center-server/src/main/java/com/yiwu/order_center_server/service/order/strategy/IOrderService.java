/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.order.strategy;

/**
 * @Author fuzf
 * @Date 2022/4/18:17:00
 * @Description:
 */

public interface IOrderService {
    /**
     * 根据订单的不同类型做出不同的处理
     *
     * @param type 订单实体
     * @return 为了简单，返回字符串
     */
    String orderHandler(String type);


}
