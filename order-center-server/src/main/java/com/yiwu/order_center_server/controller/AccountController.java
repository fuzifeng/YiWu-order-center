/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.common.bean.Encrypt;
import com.yiwu.order_center_server.dao.AccountDao;
import com.yiwu.order_center_server.dao.dto.AccountRegisterDto;
import com.yiwu.order_center_server.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author fuzf
 * @Date 2022/1/6:18:40
 * @Description:
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;


    @PostMapping("/register")
    public Resp<Long> register(@RequestParam String name,
                               @RequestParam String account,
                               @RequestParam String password) {

//        accountDao.register2(name, account, password);
        accountDao.register(name, new Encrypt(account), new Encrypt(password));
        return Resp.success();
    }

    @GetMapping("/findByAccount")
    public Resp<AccountRegisterDto> findByAccount(String account) {
        AccountRegisterDto byAccount = accountDao.findByAccount(new Encrypt(account));
        return Resp.success(byAccount);
    }
}
