/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.jwt.UserTokenDto;
import com.yiwu.order_center_server.utils.JwtUtils;
import com.yiwu.order_center_server.utils.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author fuzf
 * @Date 2022/7/27:10:41
 * @Description:
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    private static String admin = "fuzifeng";

    @PostMapping("/in")
    public Resp<String> login(@RequestParam String username,
                              @RequestParam String password) {

        if (!admin.equals(username)) {
            return Resp.error("不存在的用户名");
        }

        UserTokenDto dto = new UserTokenDto();
        dto.setUcode(StringUtils.ucode());
        dto.setUsername(username);
        String s = JwtUtils.generateToken(dto);

        return Resp.success(s);
    }



}
