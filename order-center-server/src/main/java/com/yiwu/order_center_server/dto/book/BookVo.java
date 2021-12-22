/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.dto.book;

import lombok.Data;

import java.util.Date;

/**
 * @Author fuzf
 * @Date 2021/12/21:14:04
 * @Description:
 */
@Data
public class BookVo {
    private Long id;
    private Long bid;
    private String name;
    private String author;
    private String content;
    private Double price;
    private String ucode;
    private Date publishTime;
}
