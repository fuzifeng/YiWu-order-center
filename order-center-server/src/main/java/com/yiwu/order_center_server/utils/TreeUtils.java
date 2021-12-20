/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.utils;

import com.yiwu.order_center_server.common.bean.TreeNode;
import com.yiwu.order_center_server.domain.RawMaterialCategory;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author fuzf
 * @Date 2021/12/20:15:28
 * @Description:
 */

public class TreeUtils {

    public static void main(String[] args) {
        List<RawMaterialCategory> instance = getInstance();
        List<TreeNode> tree = getTree(instance);
        int i = 0;
    }


    public static List<TreeNode> getTree(List list) {
        List<TreeNode> rootList = new ArrayList<>();

        if (CollectionUtils.isEmpty(list)) {
            return rootList;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object node = iterator.next();
            TreeNode dto = new TreeNode();
            if (node != null) {
                BeanUtils.copyProperties(node, dto,"children");
                rootList.add(dto);
            }
        }
        return deal(rootList);
    }

    private static List<TreeNode> deal(List<TreeNode> list) {
        List<TreeNode> roots = getRootList(list);
        for (int i = 0; i < roots.size(); i++) {
            addChildren(roots.get(i), list);
        }
        return roots;
    }

    private static void addChildren(TreeNode father, List<TreeNode> nodes) {
        if (CollectionUtils.isEmpty(nodes)) {
            return;
        }
        List<TreeNode> children = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (node.getParentId() != null && node.getParentId().equals(father.getId())) {
                children.add(node);
                nodes.remove(node);
                i--;
            }
        }
        if (CollectionUtils.isNotEmpty(children)) {
            Collections.sort(children, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    return o1.getSort() - o2.getSort();
                }
            });
            father.setChildren(children);
            for (int j = 0; j < children.size(); j++) {
                addChildren(children.get(j), nodes);
            }
        }
    }

    private static List<TreeNode> getRootList(List<TreeNode> list) {
        List<TreeNode> roots = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node.getParentId() == null || node.getParentId() == 0L) {
                roots.add(node);
                list.remove(node);
                i--;
            }
        }
        Collections.sort(roots, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.getSort() - o2.getSort();
            }
        });
        return roots;
    }

    public static List<RawMaterialCategory> getInstance() {
        List<RawMaterialCategory> list = new ArrayList<>();
        RawMaterialCategory category = new RawMaterialCategory();
        category.setId(1L);
        category.setParentId(0L);
        category.setSort(1);
        category.setName("一级1");
        RawMaterialCategory category2 = new RawMaterialCategory();
        category2.setId(2L);
        category2.setParentId(0L);
        category2.setSort(2);
        category2.setName("一级2");
        RawMaterialCategory category3 = new RawMaterialCategory();
        category3.setId(3L);
        category3.setParentId(2L);
        category3.setSort(3);
        category3.setName("二级1");
        RawMaterialCategory category4 = new RawMaterialCategory();
        category4.setId(4L);
        category4.setParentId(2L);
        category4.setSort(2);
        category4.setName("二级2");
        RawMaterialCategory category5 = new RawMaterialCategory();
        category5.setId(5L);
        category5.setParentId(4L);
        category5.setSort(1);
        category5.setName("三级1");
        list.add(category);
        list.add(category2);
        list.add(category3);
        list.add(category4);
        list.add(category5);
        return list;
    }
}
