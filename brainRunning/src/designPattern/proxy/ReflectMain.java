/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package designPattern.proxy;

import designPattern.proxy.staticProxy.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author fuzf
 * @Date 2022/6/13:18:23
 * @Description:
 *  反射
 */

public class ReflectMain {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class clazz = Person.class;

        //获取所有public构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("-------------------------");

        //获取所有的构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
        System.out.println("-------------------------");

        //获取固定参数的构造方法，可以为空
        Constructor c = clazz.getConstructor(String.class, String.class);
        System.out.println(c);

        Object object = clazz.newInstance();
        c = clazz.getDeclaredConstructor(String.class);
        System.out.println(c);
        //调用构造方法
        c.setAccessible(true);
        object = c.newInstance("fuzf");

        System.out.println("-------------------------");

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

    }
}
