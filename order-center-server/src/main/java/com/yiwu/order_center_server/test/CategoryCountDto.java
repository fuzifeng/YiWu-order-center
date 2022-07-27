/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.test;

import lombok.Data;

/**
 * @Author fuzf
 * @Date 2022/7/1:16:17
 * @Description:
 */
@Data
public class CategoryCountDto {
    private Integer goodsCategoryId;
    private String goodsCategoryCode;
    private Integer amount;

    public CategoryCountDto(Integer goodsCategoryId, String goodsCategoryCode, Integer amount) {
        this.goodsCategoryId = goodsCategoryId;
        this.goodsCategoryCode = goodsCategoryCode;
        this.amount = amount;
    }
}
