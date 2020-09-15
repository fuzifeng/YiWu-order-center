package com.yiwu.order_center_client.common.enums;

/**
 * @Author: fuzf
 * @Date: 2020/9/15 10:05
 */
public enum StatusEnum {
    VALID(1,"启用"),
    UN_VALID(0,"禁用"),

    ;
    private int code;
    private String name;

    StatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
