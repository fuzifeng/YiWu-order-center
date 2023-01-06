/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package io_test.bio_test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author fuzf
 * @Date 2022-11-23 16:17
 * @Description:
 */

public class SocketClientDaemon {

    public static void main(String[] args) throws InterruptedException {
        int clientNum = 2;
        CountDownLatch countDownLatch = new CountDownLatch(clientNum);
        //分别开始启动这20个客户端
        for(int index = 0 ; index < clientNum ; index++ , countDownLatch.countDown()) {
            SocketClientRequestThread client = new SocketClientRequestThread(countDownLatch, index);
            new Thread(client).start();
        }
        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (SocketClientDaemon.class) {
            SocketClientDaemon.class.wait();
        }
    }
}
