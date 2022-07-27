/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.test;/**
 * @Author fuzf
 * @Date 2022/7/14:17:11
 * @Description:
 */

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/7/14 17:11
 * @updatedAt 2022/7/14 17:11
 */
public class ForTest {

    public static void main(String[] args) {
        List<CategoryCountDto> list = new ArrayList<>();
        list.add(new CategoryCountDto(274, "1126", 1));
        list.add(new CategoryCountDto(275, "1127", 1));
        list.add(new CategoryCountDto(28425, "1192", 1));
        list.add(new CategoryCountDto(28426, "11921001", 1));
        list.add(new CategoryCountDto(28427, "11921002", 1));
        list.add(new CategoryCountDto(28428, "11921003", 1));
        list.add(new CategoryCountDto(28429, "11931001", 1));
        list.add(new CategoryCountDto(28430, "11931002", 1));
        list.add(new CategoryCountDto(28431, "11931003", 1));
        list.add(new CategoryCountDto(28432, "11941001", 1));
        list.add(new CategoryCountDto(28433, "11941002", 1));
        list.add(new CategoryCountDto(86238, "1300", 1));
        Map<String, Integer> map = new HashMap<>(list.size());

        if (CollectionUtils.isNotEmpty(list)) {
//            Map<Long, Integer> map = new HashMap<>(list.size());
//            if (list.size() == 1) {
//                map.put(list.get(0).getGoodsCategoryId(), list.get(0).getAmount());
//            } else {
                for (int i = 0; i < list.size(); i++) {
                    CategoryCountDto categoryCountDto = list.get(i);
                    int count = categoryCountDto.getAmount();
                    for (int j = i + 1; j < list.size(); j++) {
                        CategoryCountDto sub = list.get(j);
                        if (sub.getGoodsCategoryCode().startsWith(categoryCountDto.getGoodsCategoryCode())) {
                            count += sub.getAmount();
                        } else {
                            break;
                        }
                    }
                    map.put(categoryCountDto.getGoodsCategoryCode(), count);
                }
//            }
        }
        int i=0;
    }
}
