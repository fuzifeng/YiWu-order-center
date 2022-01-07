/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.dao.dto;

import com.yiwu.order_center_server.common.bean.Encrypt;
import lombok.Data;

/**
 * @Author fuzf
 * @Date 2022/1/7:09:58
 * @Description:
 */

@Data
public class AccountRegisterDto {
    private Long id;
    private String name;
    private Encrypt  account;
    private Encrypt password;

}
