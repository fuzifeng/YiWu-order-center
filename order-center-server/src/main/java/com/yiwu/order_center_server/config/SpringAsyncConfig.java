/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.config;/**
 * @Author fuzf
 * @Date 2022/1/6:16:34
 * @Description:
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.tool.XMLBean;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/1/6 16:34
 * @updatedAt 2022/1/6 16:34
 */
@Configuration
@EnableAsync
@Slf4j
public class SpringAsyncConfig implements AsyncConfigurer {


    @Bean("customerTaskPool")
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("customerTaskPool-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(9);
        executor.setBeanName("what bean name");

        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    /**
     * 捕捉IllegalArgumentException异常
     *
     * @param
     * @return
     * @author fuzf
     * @createAt 2022/1/6 17:19
     * @updateAt 2022/1/6 17:19
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("Exception message -- " + throwable.getMessage());
            log.info("message name -- " + method.getName());
            for (Object o : objects) {
                log.info("param value -- " + o);
            }
        }
    }
}
