package com.yiwu.order_center_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yiwu.order_center_server.dao")

public class OrderCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCenterServerApplication.class, args);
    }


}
