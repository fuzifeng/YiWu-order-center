package com.yiwu.order_center_server.domain;


import lombok.Data;

import java.util.Date;

/**
 * @author fuzifeng
 * @date 2020-09-14 18:29:42
 */
@Data
public class BillType {

	private Long id;
	/**
	 * 父id
	 */
	private Long parentId;
	/**
	 * 类型（PERSON，COMPANY）
	 */
	private String type;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 
	 */
	private Integer isDel;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
