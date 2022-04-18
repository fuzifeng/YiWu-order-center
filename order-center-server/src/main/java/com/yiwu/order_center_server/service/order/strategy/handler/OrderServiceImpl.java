/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.order.strategy.handler;

import com.yiwu.order_center_server.service.order.strategy.AOrderTypeHandler;
import com.yiwu.order_center_server.service.order.strategy.HandlerContext;
import com.yiwu.order_center_server.service.order.strategy.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author fuzf
 * @Date 2022/4/18:17:04
 * @Description:
 */
@Component
public class OrderServiceImpl implements IOrderService {
    //使用策略模式实现
    @Autowired
    private HandlerContext handlerContext;


    @Override
    public String orderHandler(String type) {
        /*
         * 1：使用if..else实现
         * 2：使用策略模式实现
         */
        AOrderTypeHandler instance = handlerContext.getInstance(type);
        return instance.handler(null);
    }
}
