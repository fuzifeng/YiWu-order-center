/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.enums;


/**
 * @Author fuzf
 * @Date 2022/4/18:15:11
 * @Description:
 */
public enum OrderTypeEnum {
    NORMAL("1", "普通"),
    GROUP("2", "团队"),
    PROMOTION("3", "促销");

    private String code;    //代码
    private String name;    //名称，描述

    OrderTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据code属性获取name属性
     *
     * @param code
     * @return
     */
    public static String getNameByCode(String code) {
        for (OrderTypeEnum temp : OrderTypeEnum.values()) {
            if (temp.getCode().equals(code)) {
                return temp.getName();
            }
        }
        return null;
    }
}
