/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.config.target.NotRepeatSubmit;
import com.yiwu.order_center_server.domain.Account;
import com.yiwu.order_center_server.dto.token.AccessToken;
import com.yiwu.order_center_server.dto.token.AppInfo;
import com.yiwu.order_center_server.dto.token.TokenInfo;
import com.yiwu.order_center_server.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author fuzf
 * @Date 2022/1/7:15:08
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping
    public Resp apiToken(String appId,
                         @RequestHeader("timestamp") String timestamp,
                         @RequestHeader("sign") String sign) {
        long reqeustInterval = System.currentTimeMillis() - Long.valueOf(timestamp);
        Assert.isTrue(reqeustInterval < 5 * 60 * 1000, "请求过期，请重新请求");

        // 1. 根据appId查询数据库获取appSecret

        AppInfo appInfo = new AppInfo("1", "12345678954556");
        // 2. 校验签名
        String signString = timestamp + appId + appInfo.getKey();
        String signature = MD5Util.encode(signString);
        log.info(signature);
        Assert.isTrue(signature.equals(sign), "签名错误");

        AccessToken accessToken = this.saveToken(0, appInfo, null);
        return Resp.success(accessToken);
    }


    private AccessToken saveToken(int tokenType, AppInfo appInfo, Account userInfo) {
        String token = UUID.randomUUID().toString();
        // token有效期为2小时
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, 7200);
        Date expireTime = calendar.getTime();
        // 4. 保存token
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setTokenType(tokenType);
        tokenInfo.setAppInfo(appInfo);
        if (tokenType == 1) {
            tokenInfo.setAccount(userInfo);
        }
        redisTemplate.opsForValue().set(token, tokenInfo, 7200, TimeUnit.SECONDS);
        AccessToken accessToken = new AccessToken(token, expireTime);
        return accessToken;
    }

    @NotRepeatSubmit(5000)
    @PostMapping("user_token")
    public Resp<Account> userToken(String username, String password) {
        // 根据用户名查询密码, 并比较密码(密码可以RSA加密一下)
        Account userInfo = new Account();
        String pwd = password;
        String passwordMD5 = MD5Util.encode(pwd);
        Assert.isTrue(passwordMD5.equals(userInfo.getPassword()), "密码错误");
        // 2. 保存Token
        AppInfo appInfo = new AppInfo("1", "12345678954556");
        AccessToken accessToken = this.saveToken(1, appInfo, userInfo);
        // userInfo.setAccessToken(accessToken);
        return Resp.success(userInfo);
    }
}
