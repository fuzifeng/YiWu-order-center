/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.yiwu.order_center_server.jwt.UserTokenDto;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author fuzf
 * @Date 2022/7/26:16:22
 * @Description:
 */

@Slf4j
public class JwtUtils {

    private static final String TOKEN_SECRET = "12346578";

    public static String generateToken(UserTokenDto o) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

        Map<String, Object> header = new HashMap<>();
        header.put("type", "Jwt");
        header.put("alg", "HS256");

        return JWT.create()
                .withHeader(header)
                .withClaim("token", new Gson().toJson(o))
//                .withExpiresAt(new Date())
                .sign(algorithm);

    }

    public static UserTokenDto parseToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier build = JWT.require(algorithm).build();
        DecodedJWT verify = build.verify(token);
        String tokenStr = verify.getClaim("token").asString();
        return new Gson().fromJson(tokenStr, UserTokenDto.class);
    }
}
