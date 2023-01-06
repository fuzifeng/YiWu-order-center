/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.test.nettytest;

import io.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.util.concurrent.Executors;

/**
 * @Author fuzf
 * @Date 2022-12-19 16:41
 * @Description:
 */

public class NettyServer {

    private static int HEADER_LENGTH = 4;

    public void bind(int port) throws Exception {
        /*ServerBootstrap serverBootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()));
*/

    }

}
