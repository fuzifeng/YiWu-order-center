/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.order.strategy;

import java.util.Map;

/**
 * @Author fuzf
 * @Date 2022/4/18:16:25
 * @Description:
 */
/**
 * 订单策略模式环境
 * 这个类的注入由HandlerProccessor实现
 */
public class HandlerContext {
    private Map<String, AOrderTypeHandler> handlerMap;

    /**
     * 构造传参不能直接使用注解扫入
     */
    public HandlerContext(Map<String, AOrderTypeHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    /**
     * 获得实例
     *
     * @param type
     * @return
     */
    public AOrderTypeHandler getInstance(String type) {
        if (type == null) {
            throw new IllegalArgumentException("type参数不能为空");
        }
        AOrderTypeHandler clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("该类型没有在枚举OrderTypeHandlerAnno中定义，请定义：" + type);
        }
        return clazz;
    }
}
