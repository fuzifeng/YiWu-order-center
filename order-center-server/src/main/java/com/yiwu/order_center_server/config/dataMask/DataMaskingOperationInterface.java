/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.config.dataMask;

/**
 * @Author fuzf
 * @Date 2022/8/18:16:07
 * @Description:
 */

public interface DataMaskingOperationInterface {
    String MASK_CHAR = "*";

    String mask(String content, String maskChar);
}
