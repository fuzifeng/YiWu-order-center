/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author fuzf
 * @Date 2022/1/6:16:28
 * @Description:
 */

@Service
@Slf4j
public class AsyncService {

    @Async("customerTaskPool")
    public void simpleAsync() {
        int i = 0;
        log.error("进来了吗");
        throw new IllegalArgumentException("sad");
    }

}
