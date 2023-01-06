/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package io_test.bio_test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author fuzf
 * @Date 2022-11-23 15:10
 * @Description:
 */

public class SocketServer1 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(83);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
//                System.out.println("-------");
//                Thread.sleep(5000);
                //下面是我们收到的信息
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                int port = socket.getPort();
                int max = 2048;
                byte[] contextBytes = new byte[max];
                //这里会阻塞，直到有数据准备好
                int read = inputStream.read(contextBytes, 0, max);
                //读取信息
                String message = new String(contextBytes, 0, read);
                //打印信息
                System.out.println("服务器收到来自于端口: " + port + "的信息: " + message);
                outputStream.write("回发响应信息！".getBytes());
                outputStream.close();
                inputStream.close();
                socket.close();
            }
        } catch (Exception e) {
            System.out.println("出现异常：" + e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
