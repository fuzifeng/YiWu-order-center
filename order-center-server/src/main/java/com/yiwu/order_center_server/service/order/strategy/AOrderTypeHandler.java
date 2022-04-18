/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.order.strategy;

import com.yiwu.order_center_server.domain.Order;

/**
 * @Author fuzf
 * @Date 2022/4/18:16:27
 * @Description:
 */

public abstract class AOrderTypeHandler {
    /**
     * 一个订单类型做一件事
     *
     * @param dto 订单实体
     * @return 为了简单，返回字符串
     */
    abstract public String handler(Order dto);
}
