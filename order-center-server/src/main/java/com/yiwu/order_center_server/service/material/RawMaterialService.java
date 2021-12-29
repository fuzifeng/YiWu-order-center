/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.material;/**
 * @Author fuzf
 * @Date 2021/12/24:17:35
 * @Description:
 */

import com.yiwu.order_center_server.dao.RawMaterialsDao;
import com.yiwu.order_center_server.domain.RawMaterials;
import com.yiwu.order_center_server.es.bean.RawMaterialsEs;
import com.yiwu.order_center_server.es.repositories.RawMaterialRepositories;
import com.yiwu.order_center_server.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/24 17:35
 * @updatedAt 2021/12/24 17:35
 */
@Service
public class RawMaterialService {
    @Autowired
    RawMaterialRepositories rawMaterialRepositories;

    @Autowired
    RawMaterialsDao rawMaterialsDao;

    @Transactional
    public Long addRawMaterials(RawMaterials rawMaterials) {
        rawMaterialsDao.insert(rawMaterials);
        return rawMaterials.getId();
    }

    /**
     * 添加数据到es中
     *
     * @param
     * @return
     * @author fuzf
     * @createAt 2021/12/27 14:52
     * @updateAt 2021/12/27 14:52
     */
    public void saveRawMaterialEs(Long id) {
        RawMaterials rawMaterials = rawMaterialsDao.selectById(id);
        if (rawMaterials != null) {
            RawMaterialsEs es = new RawMaterialsEs();
            es.setId(id);
            es.setName(rawMaterials.getName());
            es.setCategoryId(rawMaterials.getCategoryId());
            es.setCategoryCode(rawMaterials.getCategoryCode());
            es.setStatus(rawMaterials.getStatus());
            es.setIsDel(rawMaterials.getIsDel());
            es.setCreateTime(DateTimeUtils.dateTransferLocalDteTime(rawMaterials.getCreateTime()));
            es.setUpdateTime(LocalDateTime.now());
            rawMaterialRepositories.save(es);
        }
    }
}
