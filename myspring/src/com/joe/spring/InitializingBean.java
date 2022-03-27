package com.joe.spring;

/**
 * @Author: fuzf
 * @Date: 2022/3/25 23:35
 */
public interface InitializingBean {
    //初始化方法
    public void afterPropertiesSet();
}
