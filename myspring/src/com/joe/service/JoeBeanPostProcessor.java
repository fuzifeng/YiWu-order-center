package com.joe.service;

import com.joe.spring.BeanPostProcessor;
import com.joe.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: fuzf
 * @Date: 2022/3/25 23:42
 */
@Component
public class JoeBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        //可以单独处理，比如只处理userService
        if ("userService".equals(beanName)) {
            System.out.println("before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("after");
            Object proxyInstance = Proxy.newProxyInstance(JoeBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),
                    new InvocationHandler() {

                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("切面 代理");

                            return method.invoke(bean, args);
                        }

                    });
            return proxyInstance;
        }
        return bean;
    }
}
