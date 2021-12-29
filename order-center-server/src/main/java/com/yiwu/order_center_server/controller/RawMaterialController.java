/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;
import java.util.Date;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.common.rabbitmq.producer.TopicSender;
import com.yiwu.order_center_server.domain.RawMaterials;
import com.yiwu.order_center_server.dto.rawMaterial.RawMaterialSaveDto;
import com.yiwu.order_center_server.service.material.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/24 17:21
 * @updatedAt 2021/12/24 17:21
 */
@RestController
@RequestMapping("/rawMaterial")
public class RawMaterialController {
    @Autowired
    RawMaterialService rawMaterialService;
    @Autowired
    TopicSender topicSender;



    @PostMapping("/saveRawMaterial")
    public Resp<Long> saveRawMaterial(@RequestBody RawMaterialSaveDto save) {
        RawMaterials rawMaterials = new RawMaterials();
        rawMaterials.setName(save.getName());
        rawMaterials.setCategoryId(save.getCategoryId());
        rawMaterials.setCategoryCode(save.getCategoryCode());
        rawMaterials.setStatus(0);
        rawMaterials.setIsDel(0);
        rawMaterials.setCreateTime(new Date());
        rawMaterials.setUpdateTime(new Date());
        Long aLong = rawMaterialService.addRawMaterials(rawMaterials);

        topicSender.sendRawMaterial(aLong);
        return Resp.success(aLong);
    }

}
