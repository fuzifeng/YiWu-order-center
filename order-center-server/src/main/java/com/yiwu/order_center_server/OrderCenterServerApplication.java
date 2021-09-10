package com.yiwu.order_center_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fuzf
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.yiwu.order_center_server.dao")
public class OrderCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCenterServerApplication.class, args);
    }


}
