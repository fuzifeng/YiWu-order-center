package com.yiwu.order_center_server.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RawMaterialCategory {

    private Long id;

    private Long parentId;

    private String code;

    private Long topId;

    private Integer sort;

    private String name;

    private Integer level;

    private Integer status;

    private Integer isDel;

    private Date createTime;

    private Date updateTime;

}