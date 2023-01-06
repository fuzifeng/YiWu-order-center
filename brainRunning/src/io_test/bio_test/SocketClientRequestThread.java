/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package io_test.bio_test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 * @Author fuzf
 * @Date 2022-11-23 15:23
 * @Description:
 */

public class SocketClientRequestThread implements Runnable{
    private CountDownLatch countDownLatch;

    private Integer clientIndex;

    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }


    @Override
    public void run() {
        Socket socket = null;
        OutputStream request = null;
        InputStream response = null;
        try {
            socket = new Socket("localhost", 83);
            request = socket.getOutputStream();
            response = socket.getInputStream();

            //等待，直到所有线程启动，所有线程一起发送请求
            this.countDownLatch.await();

            //发送请求
            request.write(("这是第" + this.clientIndex + " 个客户端的请求。").getBytes());
            request.flush();
            System.out.println("第" + this.clientIndex + "个客户端的请求发送完成，等待服务器返回信息");
            int max = 1024;
            byte[] contextBytes = new byte[max];
            int readLen;
            String message = "";
            //程序执行到这里，会一直等待服务器返回信息(注意，前提是in和out都不能close，如果close了就收不到服务器的反馈了)
            while ((readLen = response.read(contextBytes, 0, max)) != -1) {
                message += new String(contextBytes, 0, readLen);
            }
            System.out.println("接收到来自服务器的信息:" + message);
        } catch (Exception e) {
            System.out.println("请求失败：" + e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (request != null) {
                    request.close();
                }
            } catch (Exception e) {
                System.out.println("失败：" + e.getMessage());
            }
        }
    }
}
