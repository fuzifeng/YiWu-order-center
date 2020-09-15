package com.yiwu.order_center_client.common.enums;

/**
 * @Author: fuzf
 * @Date: 2020/9/15 10:04
 */
public enum DelEnum {
    DELETE(1,"已删除"),
    NO(0,"未删除")
    ;
    private int code;
    private String name;

    DelEnum(int code, String name) {
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
