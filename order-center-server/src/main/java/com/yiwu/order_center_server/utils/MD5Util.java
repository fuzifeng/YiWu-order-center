/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.utils;

import com.yiwu.order_center_server.domain.Account;
import com.yiwu.order_center_server.dto.token.AccessToken;
import com.yiwu.order_center_server.dto.token.AppInfo;
import com.yiwu.order_center_server.dto.token.TokenInfo;
import org.springframework.data.redis.core.ValueOperations;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Md5工具
 *
 * @Author fuzf
 * @Date 2022/1/7:16:07
 * @Description:
 */
public class MD5Util {

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String encode(String origin) {
        return encode(origin, "UTF-8");
    }

    public static String encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
        } catch (Exception exception) {

        }
        return resultString;
    }
}
