package com.yiwu.order_center_server.dao;

import com.yiwu.order_center_server.platform.domain.Goods;

import java.util.List;

public interface PlatformGoodsDao {
    int insert(Goods goods);
    int updateById(Goods goods);

    List<Goods> findByObject(Goods var1);
    Goods findById(Long id);
}
