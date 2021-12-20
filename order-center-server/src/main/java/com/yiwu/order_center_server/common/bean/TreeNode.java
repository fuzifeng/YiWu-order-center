/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @Author fuzf
 * @Date 2021/12/20:14:57
 * @Description:
 */
@Data
public class TreeNode {
    private Long id;
    private Long parentId;
    private String name;
    private Integer sort;
    private List<TreeNode> children;
}
