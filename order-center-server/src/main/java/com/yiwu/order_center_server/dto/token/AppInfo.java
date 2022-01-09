/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.dto.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fuzf
 * @Date 2022/1/7:15:48
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {
    private String appId;
    private String key;
}
