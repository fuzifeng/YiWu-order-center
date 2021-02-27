package com.yiwu.order_center_server.service.repository;

import com.yiwu.order_center_server.domain.redis.OrderCache;
import org.springframework.data.repository.CrudRepository;

public interface OrderCacheRepository extends CrudRepository<OrderCache, Long> {
    OrderCache findByOrderNo(String orderNo);
}
