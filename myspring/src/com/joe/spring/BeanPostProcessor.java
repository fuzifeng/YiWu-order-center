package com.joe.spring;

/**
 * @Author: fuzf
 * @Date: 2022/3/25 23:41
 */
public interface BeanPostProcessor {
    public void postProcessBeforeInitialization(String beanName, Object bean);
    public Object postProcessAfterInitialization(String beanName, Object bean);

}
