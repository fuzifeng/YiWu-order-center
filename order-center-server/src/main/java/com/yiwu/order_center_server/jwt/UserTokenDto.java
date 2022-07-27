/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.jwt;

import lombok.Data;

/**
 * @Author fuzf
 * @Date 2022/7/27:10:29
 * @Description:
 */

@Data
public class UserTokenDto {
    private String ucode;
    private String username;
}
