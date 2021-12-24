/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.platform;/**
 * @Author fuzf
 * @Date 2021/12/22:18:43
 * @Description:
 */

import com.yiwu.order_center_client.common.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/22 18:43
 * @updatedAt 2021/12/22 18:43
 */
@Api(tags="平台数据初始化")
@RestController
@RequestMapping("/platform")
public class PlatGoodsController {

    @Autowired
    PlatformService platformService;

    @GetMapping("/initData")
    public Resp<Integer> initData(Integer num) {
        if (num == null || num < 0) {
            num = 9999999;
        }
        return Resp.success(platformService.dealService(num));
    }
}
