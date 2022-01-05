/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;/**
 * @Author fuzf
 * @Date 2022/1/4:17:31
 * @Description:
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2022/1/4 17:31 
 * @updatedAt 2022/1/4 17:31
 */
public class PrintFoobarAlternatelyMain {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private Semaphore fooSema = new Semaphore(1);
    private Semaphore barSema = new Semaphore(0);

    public static void main(String[] args) {
        PrintFoobarAlternatelyMain foo = new PrintFoobarAlternatelyMain(5);
        Runnable foop = () -> System.out.println("foo");
        Runnable bar = () -> System.out.println("bar");
        new Thread(() -> {
            try {
                foo.foo(foop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    private int n;

    public PrintFoobarAlternatelyMain(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSema.acquire();//值为1的时候，能拿到，执行下面的操作
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSema.release();//释放许可给barSema这个信号量 barSema 的值+1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSema.acquire();

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSema.release();//释放许可给fooSema这个信号量 fooSema 的值+1
        }
    }
}
