package com.yiwu.order_center_server.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: fuzf
 * @Date: 2020/9/10 15:23
 */
@Data
public class Order {

    private Long id;
    private String orderNo;
    private Long totalMoney;
    private Date createTime;
    private Date updateTime;
}
