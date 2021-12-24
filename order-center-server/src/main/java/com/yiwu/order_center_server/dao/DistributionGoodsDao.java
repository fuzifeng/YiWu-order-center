package com.yiwu.order_center_server.dao;


import com.yiwu.order_center_server.platform.domain.DistributionGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistributionGoodsDao {
    int insert(DistributionGoods goods);
    int updateById(DistributionGoods goods);

    List<DistributionGoods> findByObject(DistributionGoods var1);
    DistributionGoods findById(Long id);

    List<DistributionGoods> selectToDealList(@Param("num") Integer num);

}
