package com.joe.service;

import com.joe.spring.MyApplicationContext;

/**
 * @Author: fuzf
 * @Date: 2022/3/24 22:53
 */
public class Test {

    public static void main(String[] args) {

        MyApplicationContext myApplicationContext = new MyApplicationContext(AppConfig.class);
        UserService userService = (UserService) myApplicationContext.getBean("userService");

    }
}
