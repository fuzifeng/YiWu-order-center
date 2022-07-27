package com.joe.service;

import com.joe.spring.ComponentScan;
import org.springframework.context.annotation.Bean;

/**
 * @Author: fuzf
 * @Date: 2022/3/24 22:55
 */

@ComponentScan("com.joe.simpleSpring.service")
public class AppConfig {

    @Bean("orderService1")
    public OrderService orderService1() {
        return new OrderService();
    }


    @Bean
    public OrderService orderService2() {
        return new OrderService();
    }

}
