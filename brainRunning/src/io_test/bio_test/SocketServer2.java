/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package io_test.bio_test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author fuzf
 * @Date 2022-11-24 15:09
 * @Description:
 */

public class SocketServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(83);

        try {
            while (true) {
                Socket accept = serverSocket.accept();
                //当然业务处理过程可以交给一个线程(这里可以使用线程池),并且线程的创建是很耗资源的。
                //最终改变不了.accept()只能一个一个接受socket的情况,并且被阻塞的情况
                SocketServerThread thread = new SocketServerThread(accept);
                new Thread(thread).start();
                System.out.println("111");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
