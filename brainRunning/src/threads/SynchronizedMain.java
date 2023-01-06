/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author fuzf
 * @Date 2022-11-22 18:18
 * @Description:
 */

public class SynchronizedMain {

    public static void main(String[] args) {
        SynchronizedMain sm1 = new SynchronizedMain();
        SynchronizedMain sm2 = new SynchronizedMain();
        SynchronizedMain sm3 = new SynchronizedMain();
        SynchronizedMain sm4 = new SynchronizedMain();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> sm1.func());
        executorService.execute(() -> sm2.func());
        executorService.execute(() -> sm3.func());
        executorService.execute(() -> sm4.func());
//        SynchronizedMain sm = new SynchronizedMain();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->sm.func2());
//        executorService.execute(()->sm.func2());
//        executorService.execute(()->sm.func2());

    }

    /**
     * 作用在对象
     */
    public void func() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
            }
//            System.out.println();
        }
    }

    public void func2() {
        synchronized (SynchronizedMain.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
            }
//            System.out.println();
        }
    }



}
