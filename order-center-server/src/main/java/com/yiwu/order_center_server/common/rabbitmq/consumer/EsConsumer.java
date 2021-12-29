/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.common.rabbitmq.consumer;/**
 * @Author fuzf
 * @Date 2021/12/27:11:45
 * @Description:
 */

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.yiwu.order_center_server.common.rabbitmq.dto.EsRabbitmqInfoDto;
import com.yiwu.order_center_server.config.RabbitConfig;
import com.yiwu.order_center_server.service.material.RawMaterialService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * todo 写下 你的注释
 *
 * @author fuzifeng
 * @version 1.0.0
 * @createdAt 2021/12/27 11:45
 * @updatedAt 2021/12/27 11:45
 */
@Component
public class EsConsumer {
    @Autowired
    RawMaterialService rawMaterialService;


    @RabbitListener(queues = RabbitConfig.ES_QUEUE)
    public void receive(String message) {
        System.out.println(new Date());
        System.out.println("EsConsumer info : " + message);
        EsRabbitmqInfoDto dto = new Gson().fromJson(message, EsRabbitmqInfoDto.class);

        if (dto.getType().equals(EsRabbitmqInfoDto.TypeEnum.RAW_MATERIAL.getCode())) {
//            rawMaterialService.saveRawMaterialEs(dto.getId());
        }
    }

}
