/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.common.bean.TreeNode;
import com.yiwu.order_center_server.domain.RawMaterialCategory;
import com.yiwu.order_center_server.service.material.MaterialCategoryService;
import com.yiwu.order_center_server.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 原材料分类
 *
 * @author fuzifeng
 * @version 1.0.0
 * @createdAt 2021/12/20 14:53
 * @updatedAt 2021/12/20 14:53
 */
@RestController
@RequestMapping("/rawMaterialCategory")
public class RawMaterialCategoryController {

    @Autowired
    MaterialCategoryService materialCategoryService;

    @GetMapping("/getTree")
    public Resp<List<TreeNode>> getTree() {
        List<RawMaterialCategory> list = materialCategoryService.findList();
        List<TreeNode> tree = TreeUtils.getTree(list);
        return Resp.success(tree);
    }

}
