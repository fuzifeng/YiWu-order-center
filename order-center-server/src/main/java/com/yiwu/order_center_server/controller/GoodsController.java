/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;/**
 * @Author fuzf
 * @Date 2021/12/17:14:09
 * @Description:
 */

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.es.bean.GoodsEs;
import com.yiwu.order_center_server.es.repositories.GoodsRepositories;
import com.yiwu.order_center_server.service.es.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * todo 写下 你的注释
 *
 * @author fuzifeng
 * @version 1.0.0
 * @createdAt 2021/12/17 14:09
 * @updatedAt 2021/12/17 14:09
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/addGoods")
    public Resp<Long> addGoods(@RequestBody GoodsEs goods) {
        goods.setId(System.currentTimeMillis());
        goodsService.saveGoods(goods);
        return Resp.success(goods.getId());
    }



}
