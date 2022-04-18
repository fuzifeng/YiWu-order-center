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
 * @Date 2022/4/18:16:51
 * @Description:
 */
@Component
@OrderTypeHandlerAnnotation(OrderTypeEnum.GROUP)
public class GroupOrderHandler extends AOrderTypeHandler {


    @Override
    public String handler(Order dto) {
        return "处理团队订单";
    }
}
