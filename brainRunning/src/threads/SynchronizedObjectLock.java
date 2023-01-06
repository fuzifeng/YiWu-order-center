/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

/**
 * @Author fuzf
 * @Date 2022-12-20 16:56
 * @Description:
 */

public class SynchronizedObjectLock implements Runnable{
    static SynchronizedObjectLock instance = new SynchronizedObjectLock();

    @Override
    public void run() {
        method();
        /*synchronized (this) {
            System.out.println("我是线程 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程 " + Thread.currentThread().getName()+" 结束");
        }*/
    }

    public static void main(String[] args) {
        /*Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();*/
        SynchronizedObjectLock lock = new SynchronizedObjectLock();
        lock.method1();
    }

    public synchronized void method() {
        System.out.println("我是线程 " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程 " + Thread.currentThread().getName()+" 结束");
    }

    private synchronized void method1() {
        System.out.println(Thread.currentThread().getId() + ": method1()");
        method2();
    }
    private synchronized void method2() {
        System.out.println(Thread.currentThread().getId() + ": method2()");
        method3();
    }
    private synchronized void method3() {
        System.out.println(Thread.currentThread().getId() + ": method3()");
    }
}
