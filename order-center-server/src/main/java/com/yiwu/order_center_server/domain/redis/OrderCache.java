package com.yiwu.order_center_server.domain.redis;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.stereotype.Repository;

@RedisHash(value = "redis_order", timeToLive = 120)
@Repository
@Data
public class OrderCache {
    @Id
    private Long id;
    @Indexed
    private String orderNo;
    private Long totalMoney;
}
