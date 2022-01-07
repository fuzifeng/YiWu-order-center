/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.dto.token;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author fuzf
 * @Date 2022/1/7:16:12
 * @Description:
 */

@Data
@AllArgsConstructor
public class AccessToken {
    private String token;
    private Date expireTime;
}
