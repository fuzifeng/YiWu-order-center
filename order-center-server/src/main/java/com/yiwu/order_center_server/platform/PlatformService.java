/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.platform;/**
 * @Author fuzf
 * @Date 2021/12/22:18:58
 * @Description:
 */

import com.yiwu.order_center_server.dao.DistributionGoodsDao;
import com.yiwu.order_center_server.dao.PlatformGoodsDao;
import com.yiwu.order_center_server.platform.domain.DistributionGoods;
import com.yiwu.order_center_server.platform.domain.Goods;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/22 18:58
 * @updatedAt 2021/12/22 18:58
 */
@Service
public class PlatformService {
    @Autowired
    PlatformGoodsDao platformGoodsDao;
    @Autowired
    DistributionGoodsDao distributionGoodsDao;


    @Transactional(rollbackFor = Exception.class)
    public int dealService(int num) {

        int count = 0;
        DistributionGoods params = new DistributionGoods();
        params.setIsDel(0);
//        params.setCenterType(1);
//        List<DistributionGoods> list = distributionGoodsDao.findByObject(params);
        List<DistributionGoods> list = distributionGoodsDao.selectToDealList(num);

        if (CollectionUtils.isNotEmpty(list)) {
            for (DistributionGoods distributionGoods : list) {
                Goods referGoods = platformGoodsDao.findById(distributionGoods.getGoodsId());
                if (referGoods != null) {
                    Goods goods = new Goods();
                    if (distributionGoods.getCenterType() == 1) {
                        goods.setType(3);
                    } else {
                        goods.setType(2);
                    }
                    goods.setName(distributionGoods.getName());
                    goods.setCategoryId(distributionGoods.getCategoryId());
                    goods.setCategoryCode(distributionGoods.getCategoryCode());
                    goods.setGoodsType(distributionGoods.getGoodsType());
                    goods.setPicUrl(distributionGoods.getPic());
                    goods.setReferId(referGoods.getReferId());
                    goods.setBasePrice(null);
                    goods.setSalePrice(distributionGoods.getPrice());
                    goods.setTryWatch(referGoods.getTryWatch());
                    goods.setIsFree(distributionGoods.getIsFree());
                    if (distributionGoods.getStatus() == 1) {
                        goods.setStatus(1);
                    } else if (distributionGoods.getStatus() == 2) {
                        goods.setStatus(0);
                    } else {
                        goods.setStatus(9);
                    }
                    goods.setOnTime(distributionGoods.getOnTime());
                    goods.setOffTime(null);
                    goods.setOpenTag(0);
                    goods.setSort(distributionGoods.getSort());
                    goods.setVisibleRange(referGoods.getVisibleRange());
                    goods.setIsDel(0);
                    goods.setCreateTime(distributionGoods.getCreateTime());
                    goods.setUpdateTime(distributionGoods.getUpdateTime());
                    goods.setCreateUserId(distributionGoods.getCreateUserId());
                    goods.setUpdateUserId(distributionGoods.getUpdateUserId());
                    goods.setBranchId(distributionGoods.getBranchId());
                    goods.setSaasId(distributionGoods.getSaasId());
                    platformGoodsDao.insert(goods);

                    Long relateGoodsId = goods.getId();
                    distributionGoods.setRelateGoodsId(relateGoodsId);
                    distributionGoodsDao.updateById(distributionGoods);
                    count++;
                }
            }
        }
        return count;
    }
}
