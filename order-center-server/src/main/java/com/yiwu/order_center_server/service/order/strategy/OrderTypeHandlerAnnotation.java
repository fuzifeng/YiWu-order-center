/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.order.strategy;

import com.yiwu.order_center_server.enums.OrderTypeEnum;

import java.lang.annotation.*;

/**
 * @Author fuzf
 * @Date 2022/4/18:16:30
 * @Description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OrderTypeHandlerAnnotation {
    OrderTypeEnum value();
}
