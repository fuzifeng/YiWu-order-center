
package com.simplespring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author fuzf
 * @Date 2022/7/4:16:44
 * @Description:
 */
@Service
public class MyAsyncService {

    @Async
    public void send1() {
        System.out.println("当前线程1是：" + Thread.currentThread().getName());
    }

    @Async
    public void send2() {
        System.out.println("当前线程2是：" + Thread.currentThread().getName());
    }

}
