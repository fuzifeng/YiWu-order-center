/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.config.dataMask;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.yiwu.order_center_server.config.target.DataMasking;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author fuzf
 * @Date 2022/8/18:16:41
 * @Description:
 *   自定义 AnnotationIntrospector，适配我们自定义注解返回相应的 Serializer
 */
@Slf4j
public class DataMaskingAnnotationIntrospector extends NopAnnotationIntrospector {

    @Override
    public Object findSerializer(Annotated am) {
        DataMasking annotation = am.getAnnotation(DataMasking.class);
        if (annotation != null) {
            return new DataMaskingSerializer(annotation.maskFunc().operation());
        }
        return null;
    }

}
