/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.common.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 需要加密的字段的类
 *
 * @Author fuzf
 * @Date 2022/1/6:17:51
 * @Description:
 */
@Data
public class Encrypt {
    private String value;

    public Encrypt() {
    }

    public Encrypt(String value) {
        this.value = value;
    }
}
