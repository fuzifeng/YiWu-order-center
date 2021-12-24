package com.yiwu.order_center_server.platform.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DistributionGoods {
    private Long id;
    private Long relateGoodsId;

    private String name;

    private Integer isFree;

    private BigDecimal price;

    private Long categoryId;

    private String categoryCode;

    private String pic;

    private Integer status;

    private Long goodsId;

    private Integer goodsType;

    private BigDecimal channelRate;

    private Integer paidAmount;

    private BigDecimal paidTotalMoney;

    @ApiModelProperty(value = "上架时间")
    private Date onTime;

    private Integer centerType;

    private Long referDistributionGoodsId;

    private Long referBranchId;//服务商branchId


    private Integer sort;

    private Integer isDel;

    private Long createUserId;

    private Date createTime;

    private Long updateUserId;

    private Date updateTime;

    private Long branchId;
    private Long saasId;
    private String branchName; //培训服务商名字
    private String referBranchName; //源培训服务商名字 centerType 为2的时候填写

    //尽量不要写这里
    private Long selfBranchId;//查询用


}