/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.dto.rawMaterial;/**
 * @Author fuzf
 * @Date 2021/12/24:17:23
 * @Description:
 */

import lombok.Data;

import java.util.Date;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/24 17:23
 * @updatedAt 2021/12/24 17:23
 */
@Data
public class RawMaterialSaveDto {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryCode;
}
