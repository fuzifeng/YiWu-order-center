package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.billType.domain.BillType;
import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_client.common.enums.DelEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: fuzf
 * @Date: 2020/9/15 9:57
 */
@RestController
@RequestMapping("/web/order-center/billType")
public class BillTypeController {

    @PostMapping("/add")
    public Resp add(@RequestParam Long parentId, @RequestParam String name, @RequestParam String type) {
        Date now = new Date();
        BillType billType = new BillType();
        billType.setParentId(parentId);
        billType.setType(type);
        billType.setName(name);
        billType.setIsDel(DelEnum.NO.getCode());
        billType.setCreateTime(now);
        billType.setUpdateTime(now);
        return Resp.success();
    }
}

