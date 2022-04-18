/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.order.strategy.handler;

import com.yiwu.order_center_server.domain.Order;
import com.yiwu.order_center_server.enums.OrderTypeEnum;
import com.yiwu.order_center_server.service.order.strategy.AOrderTypeHandler;
import com.yiwu.order_center_server.service.order.strategy.OrderTypeHandlerAnnotation;
import org.springframework.stereotype.Component;

/**
 * @Author fuzf
 * @Date 2022/4/18:16:49
 * @Description:
 */
@Component
@OrderTypeHandlerAnnotation(OrderTypeEnum.NORMAL)
public class NormalOrderHandler extends AOrderTypeHandler {

    @Override
    public String handler(Order dto) {
        return "处理普通订单";
    }
}
