/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.utils.SmsService;
import com.yiwu.utils.impl.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fuzf
 * @Date 2022/5/4:15:39
 * @Description:
 */

@RestController
@RequestMapping("/starter")
public class StarterController {

    @Autowired
    SmsService smsService;

    @GetMapping("/test")
    public Resp test(int type) {
        smsService.sendSms("13655555555","love","1","在干嘛");
        return Resp.success();
    }

}
