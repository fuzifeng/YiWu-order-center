package com.yiwu.order_center_server.domain;

import lombok.Data;

/**
 * @Author fuzf
 * @Date 2021/9/15:16:25
 * @Description:
 */
@Data
public class OrderDispatch {
    private Long id;
    private Long orderId;
    private String orderNo;
    private String address;
    private Integer status;
}
