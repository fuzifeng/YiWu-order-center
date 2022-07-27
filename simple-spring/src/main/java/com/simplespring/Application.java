package com.simplespring;

/**
 * @Author fuzf
 * @Date 2022/7/4:16:53
 * @Description:
 */

import com.simplespring.service.MyAsyncService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/7/4 16:53
 * @updatedAt 2022/7/4 16:53
 */
@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        MyAsyncService bean = context.getBean(MyAsyncService.class);
        bean.send1();
        bean.send2();

    }
}
