/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author fuzf
 * @Date 2022/1/4:17:11
 * @Description:
 *
 * 按序打印
 * https://leetcode-cn.com/problems/print-in-order/submissions/
 */

public class PrintInOrderMain {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public static void main(String[] args) {
        PrintInOrderMain foo = new PrintInOrderMain();
        Runnable printFirst = () -> System.out.println("first");
        Runnable printSecond = () -> System.out.println("second");
        Runnable printThird = () -> System.out.println("third");
        new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            //循环
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            //循环
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}


