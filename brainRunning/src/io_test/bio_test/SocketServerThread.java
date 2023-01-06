/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package io_test.bio_test;/**
 * @Author fuzf
 * @Date 2022-11-24 15:13
 * @Description:
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/11/24 15:13
 * @updatedAt 2022/11/24 15:13
 */
public class SocketServerThread implements Runnable {

    private Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            //下面我们收取信息
            in = socket.getInputStream();
            out = socket.getOutputStream();
            Integer sourcePort = socket.getPort();
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            //使用线程，同样无法解决read方法的阻塞问题，
            //也就是说read方法处同样会被阻塞，直到操作系统有数据准备好
            int realLen = in.read(contextBytes, 0, maxLen);
            //读取信息
            String message = new String(contextBytes , 0 , realLen);

            //下面打印信息
            System.out.println("服务器收到来自于端口: " + sourcePort + "的信息: " + message);
            Thread.sleep(5000);
            //下面开始发送信息
            out.write("回发响应信息！".getBytes());
        } catch(Exception e) {
            System.out.println("异常:" + e.getMessage());
        } finally {
            //试图关闭
            try {
                if(in != null) {
                    in.close();
                }
                if(out != null) {
                    out.close();
                }
                if(this.socket != null) {
                    this.socket.close();
                }
            } catch (IOException e) {
                System.out.println("异常2:" + e.getMessage());

            }
        }
    }
}
