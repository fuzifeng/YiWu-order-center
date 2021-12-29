/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.common.rabbitmq.dto;/**
 * @Author fuzf
 * @Date 2021/12/27:11:47
 * @Description:
 */

import lombok.Data;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/27 11:47
 * @updatedAt 2021/12/27 11:47
 */
@Data
public class EsRabbitmqInfoDto {
    private Long id;
    private Integer type;

    public static enum TypeEnum {
        RAW_MATERIAL(1),
        GOODS(2),
        ;
        private Integer code;

        public Integer getCode() {
            return code;
        }

        TypeEnum(Integer code) {
            this.code = code;
        }
    }
}
