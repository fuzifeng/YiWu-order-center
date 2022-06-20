/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

import java.util.concurrent.CountDownLatch;

/**
 * @Author fuzf
 * @Date 2022/6/13:14:12
 * @Description:
 */


public class CacheFillMain {


    /**
     * 打开注释后，任意其他有效数据都不可能和x位于同一行
     * 减少缓存一致性的开销
     */
    private static class T{
//        private long p1,p2,p3,p4,p5,p6,p7;
        public long x = 0l;
//        private long p11,p12,p13,p14,p15,p16,p17;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 100000000; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 100000000; i++) {
                arr[1].x = i;
            }
            latch.countDown();

        });

        long l = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime()-l)/1000000);


    }

}
