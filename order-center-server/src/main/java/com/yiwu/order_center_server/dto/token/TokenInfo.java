/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.dto.token;/**
 * @Author fuzf
 * @Date 2022/1/7:16:19
 * @Description:
 */

import com.yiwu.order_center_server.domain.Account;
import lombok.Data;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/1/7 16:19 
 * @updatedAt 2022/1/7 16:19
 */
@Data
public class TokenInfo {
    /** token类型: api:0 、user:1 */
    private Integer tokenType;
    /** App 信息 */
    private AppInfo appInfo;
    /** 用户其他数据 */
    private Account account;
}
