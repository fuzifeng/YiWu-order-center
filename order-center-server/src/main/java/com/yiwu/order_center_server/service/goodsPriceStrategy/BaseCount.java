package com.yiwu.order_center_server.service.goodsPriceStrategy;

import com.yiwu.order_center_server.service.goodsPriceStrategy.domain.OrderDetail;

import java.math.BigDecimal;

/**
 * 支付基本类
 * @author admin
 *
 */
public class BaseCount implements IBaseCount{

	@Override
	public BigDecimal countPayMoney(OrderDetail orderDetail) {
		orderDetail.setPayMoney(orderDetail.getMerchandise().getPrice());
		System.out.println("商品原单价金额为：" +  orderDetail.getPayMoney());
		
		return orderDetail.getPayMoney();
	}

}
