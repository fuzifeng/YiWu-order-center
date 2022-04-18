/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.test;/**
 * @Author fuzf
 * @Date 2022/4/14:16:50
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/4/14 16:50
 * @updatedAt 2022/4/14 16:50
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};

        System.out.println(findMissingRanges(nums,-1,99));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList();
        if (lower >= upper) {
            return result;
        }
        if (nums == null || nums.length == 0) {
            result.add(lower + "->" + upper);
            return result;
        }
        int start = nums[0];
        //先处理数组前数据
        if (start > lower) {
            if (start - lower == 1) {
                result.add(lower + "");
            } else {
                result.add(lower + "->" + (start - 1));
            }
        }
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            end = nums[i];
            if (Math.abs(end - start) <= 1) {
                start = nums[i];
                continue;
            } else {
                int startRight = start + 1;
                int endLeft = end - 1;
                if (Math.abs(endLeft - startRight) <= 1) {
                    result.add(startRight + "");
                } else {
                    result.add(startRight + "->" + endLeft);
                }
                start = nums[i];
            }
        }
        if (upper - end == 1) {
            result.add(upper + "");
        } else if (upper - end > 1) {
            result.add((end + 1) + "->" + upper);
        }
        return result;

    }
}
