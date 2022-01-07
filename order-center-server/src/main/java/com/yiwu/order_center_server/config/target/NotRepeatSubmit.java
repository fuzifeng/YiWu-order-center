/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.config.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author fuzf
 * @Date 2022/1/7:16:13
 * @Description: 自定义注解，防止重复提交。
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRepeatSubmit {
    /** 过期时间，单位毫秒 **/
    long value() default 5000;
}
