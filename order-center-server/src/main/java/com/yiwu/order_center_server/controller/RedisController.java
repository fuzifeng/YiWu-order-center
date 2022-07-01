/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;/**
 * @Author fuzf
 * @Date 2021/11/3:15:04
 * @Description:
 */

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.yiwu.order_center_client.common.Resp;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * todo 写下 你的注释
 *
 * @author fuzfifeng
 * @version 1.0.0
 * @createdAt 2021/11/3 15:04
 * @updatedAt 2021/11/3 15:04
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private Redisson redisson;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/zsetTest")
    public Resp zSetTest(@RequestParam Long userId,
                         @RequestParam Integer cur) {
        Long add = redisTemplate.opsForSet().add(String.valueOf(userId), cur);
        return Resp.success(add);
    }

    @GetMapping("/getSetTest")
    public Resp getSetTest(@RequestParam String userId) {
        Set set =redisTemplate.opsForSet().members(String.valueOf(userId));
        String str = String.join(",", set);
        return Resp.success(set);
    }

    @GetMapping("/getSetLength")
    public Resp getSetLength(@RequestParam Long userId) {
//        Set set =redisTemplate.opsForSet().members(String.valueOf(userId));
        Set set =new HashSet();
        long setLength = redisTemplate.opsForSet().size(String.valueOf(userId));
        long setLength2 = redisTemplate.opsForSet().size(String.valueOf(userId + 1));
        List list = redisTemplate.opsForSet().randomMembers(String.valueOf(userId), 2);
        set.addAll(list);

        String str = set.toString();
        return Resp.success(set);
    }


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");

        String str = String.join(", ", set);

        System.out.println(str);

        Set set2 = new HashSet();
        set2.addAll(Arrays.asList(str.trim().split(",")));
        System.out.println(set2);

    }


}
