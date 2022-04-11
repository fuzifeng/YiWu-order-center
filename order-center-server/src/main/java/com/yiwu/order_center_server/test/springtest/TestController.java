/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.test.springtest;

import com.yiwu.order_center_client.common.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fuzf
 * @Date 2022/3/30:11:06
 * @Description:
 */
@RestController
@RequestMapping("/t")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public Resp test() {
        System.out.println("主线程...." + Thread.currentThread().getName());

        testService.asyncTest();
        testService.asyncTest();
        testService.asyncTest();
        return Resp.success();
    }


}
