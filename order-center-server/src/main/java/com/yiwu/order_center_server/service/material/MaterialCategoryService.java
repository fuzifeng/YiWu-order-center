/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.material;

import com.yiwu.order_center_server.dao.RawMaterialCategoryDao;
import com.yiwu.order_center_server.domain.RawMaterialCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fuzf
 * @Date 2021/12/20:15:05
 * @Description:
 */
@Service
public class MaterialCategoryService {
    @Autowired
    RawMaterialCategoryDao rawMaterialCategoryDao;


    public List<RawMaterialCategory> findList() {
        return rawMaterialCategoryDao.selectAll();
    }

}
