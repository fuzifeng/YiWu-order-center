package com.joe.service;

import com.joe.spring.MyApplicationContext;

/**
 * @Author: fuzf
 * @Date: 2022/3/24 22:53
 */
public class Test {

    //https://www.cnblogs.com/bsytz/p/15346827.html 免费试用idea
    public static void main(String[] args) {

        MyApplicationContext myApplicationContext = new MyApplicationContext(AppConfig.class);
//        System.out.println(myApplicationContext.getBean("userService"));
        UserInterface userService = (UserInterface) myApplicationContext.getBean("userService");
        userService.test();

//        System.out.println(myApplicationContext.getBean("orderService"));

    }
}
