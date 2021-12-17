/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.es;/**
 * @Author fuzf
 * @Date 2021/12/17:14:42
 * @Description:
 */

import com.yiwu.order_center_server.es.bean.GoodsEs;
import com.yiwu.order_center_server.es.repositories.GoodsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/17 14:42
 * @updatedAt 2021/12/17 14:42
 */
@Service
public class GoodsService {
    @Autowired
    GoodsRepositories goodsRepositories;

    public Long saveGoods(GoodsEs goods) {
        GoodsEs goodsEs = goodsRepositories.save(goods);
        return goodsEs.getId();
    }

}
