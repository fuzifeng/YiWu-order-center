package com.yiwu.order_center_server.platform.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods {
    private Long id;

    private Integer type;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "分类code")
    private String categoryCode;

    @ApiModelProperty(value = "商品类型（1，训练营；2，任务；3，测评）")
    private Integer goodsType;

    @ApiModelProperty(value = "封面图片")
    private String picUrl;

    @ApiModelProperty(value = "引用(训练营，任务，测评)的id")
    private Long referId;

    @ApiModelProperty(value = "基本价格")
    private BigDecimal basePrice;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "是否可以试看 0不支持，1支持")
    private Integer tryWatch;

    @ApiModelProperty(value = "是否免费 0不免费,1免费")
    private Integer isFree;

    @ApiModelProperty(value = "状态 0下架 1上架 9草稿")
    private Integer status;

    @ApiModelProperty(value = "上架时间")
    private Date onTime;

    @ApiModelProperty(value = "下架时间")
    private Date offTime;

    @ApiModelProperty(value = "是否对外开放 0不开放 1开放")
    private Integer openTag;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "可见范围 1机构,2全体,3指定学员,4指定身份")
    private Integer visibleRange;

    private Integer isDel;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

    private Long branchId;

    private Long saasId;

}