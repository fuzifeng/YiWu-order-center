/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/6/14 15:48 
 * @updatedAt 2022/6/14 15:48
 */
public class ThreadPoolMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                2,
                222,
                TimeUnit.DAYS,
                new LinkedBlockingDeque<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("测试");
                        return t;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("byebye");
            }
        });

        Future<Object> aaa = executor.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                System.out.println("aaa");
                return 2;
            }
        });

        System.out.println(aaa.get());

    }
}
