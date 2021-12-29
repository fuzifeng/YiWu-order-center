package com.yiwu.order_center_server.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RawMaterials {

    private Long id;

    private String name;

    private Long categoryId;

    private String categoryCode;

    private Integer status;

    private Integer isDel;

    private Date createTime;

    private Date updateTime;

}