/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.config.dataMask;

import com.yiwu.order_center_server.utils.StringUtils;
import org.apache.logging.log4j.util.Strings;

/**
 * @Author fuzf
 * @Date 2022/8/18:16:05
 * @Description: 自定义 Serializer，参考 jackson 的 StringSerializer，下面的示例只针对 String 类型进行脱敏
 */

public enum DataMaskingFunc {

    //不脱敏
    NO_MASK((str,maskChar)->{
        return str;
    }),

    //脱敏
    ALL_MASK((str, maskChar) -> {
        if (str != null && str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(Strings.isNotEmpty(maskChar) ? maskChar : DataMaskingOperationInterface.MASK_CHAR);
            }
            return sb.toString();
        }
        return str;
    }),
    ;

    private final DataMaskingOperationInterface dataMaskingOperationInterface;


    DataMaskingFunc(DataMaskingOperationInterface dataMaskingOperationInterface) {
        this.dataMaskingOperationInterface = dataMaskingOperationInterface;
    }

    public DataMaskingOperationInterface operation() {
        return this.dataMaskingOperationInterface;
    }
}
