CREATE TABLE `bill_type` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(255) DEFAULT '0' COMMENT '父id',
  `type` varchar(32) NOT NULL COMMENT '类型（PERSON，COMPANY）',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `is_del` int(4) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(64) NOT NULL COMMENT '订单编号',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_u_idx` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `person_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(4) NOT NULL COMMENT '类型',
  `sub_type` int(4) DEFAULT NULL COMMENT '子类型',
  `money` decimal(11,2) NOT NULL COMMENT '金额',
  `relation_id` bigint(20) DEFAULT NULL COMMENT '关联id',
  `is_del` int(4) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;