/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.config.target;


import com.yiwu.order_center_server.config.dataMask.DataMaskingFunc;

import java.lang.annotation.*;

/**
 * @Author fuzf
 * @Date 2022/8/18:16:02
 * @Description: 信息脱敏
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {
    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;
}
