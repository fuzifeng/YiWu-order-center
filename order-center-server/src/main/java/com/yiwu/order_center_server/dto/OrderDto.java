package com.yiwu.order_center_server.dto;

import com.yiwu.order_center_server.config.dataMask.DataMaskingFunc;
import com.yiwu.order_center_server.config.target.DataMasking;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: fuzf
 * @Date: 2020/11/3 14:31
 */

public class OrderDto implements Serializable {

    private Long id;
    //    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String orderNo;
    private Money totalMoney;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Money getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Money totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
