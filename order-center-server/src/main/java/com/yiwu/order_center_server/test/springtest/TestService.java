/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.test.springtest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author fuzf
 * @Date 2022/3/30:11:11
 * @Description:
 */
@Service
public class TestService {


    @Async("customerTaskPool")
    public void asyncTest() {
        System.out.println("异步操作...." + Thread.currentThread().getName());
        throw new NullPointerException();
    }
}
