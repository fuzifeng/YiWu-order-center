package com.yiwu.order_center_server.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtils {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public Object getByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
