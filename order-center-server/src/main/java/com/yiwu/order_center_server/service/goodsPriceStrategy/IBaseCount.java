package com.yiwu.order_center_server.service.goodsPriceStrategy;

import com.yiwu.order_center_server.service.goodsPriceStrategy.domain.OrderDetail;

import java.math.BigDecimal;

/**
 * 计算支付金额接口类
 * @author admin
 *
 */
public interface IBaseCount {
	
	BigDecimal countPayMoney(OrderDetail orderDetail);

}
