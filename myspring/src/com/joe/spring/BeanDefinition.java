/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.joe.spring;/**
 * @Author fuzf
 * @Date 2022/3/25:15:04
 * @Description:
 */

/**
 * Bean的定义
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/3/25 15:04
 * @updatedAt 2022/3/25 15:04
 */
public class BeanDefinition {
    private Class type;
    private String scope; // 作用域

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
