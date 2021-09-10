package com.yiwu.order_center_server.config;

/**
 * @Author fuzf
 * @Date 2021/9/10:16:10
 * @Description:
 */
public enum DataSourceEnum {

    MASTER("master"),
    SLAVE("slave");

    private String name;

    public String getDataSourceName() {
        return name;
    }

    DataSourceEnum(String name) {
        this.name = name;
    }
}
