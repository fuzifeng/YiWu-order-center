package com.yiwu.order_center_server.domain;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fuzifeng
 * @date 2020-09-14 18:29:42
 */
@Data
public class PersonBill implements Serializable {
	private Long id;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 子类型
	 */
	private Integer subType;
	/**
	 * 金额
	 */
	private BigDecimal money;
	/**
	 * 关联id
	 */
	private Long relationId;
	/**
	 * 
	 */
	private Integer isDel;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
