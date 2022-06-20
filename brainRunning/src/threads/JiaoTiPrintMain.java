/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author fuzf
 * @Date 2022/6/8:22:56
 * @Description:
 */

public class JiaoTiPrintMain {
    static Thread t1 = null, t2 = null;


    public static void main(String[] args) {
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "abcdefg".toCharArray();

        function1(a1, a2); //面试官未必想要的结果

        function2(a1, a2);
        function3(a1, a2);
        function4(a1, a2);
        function5(a1, a2);

        System.out.println(1);
        Thread.currentThread().interrupted();
        System.out.println(2);

    }

    public static void function5(char[] a1, char[] a2) {
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                for (char c : a1) {
                    System.out.println(queue.take());
                    queue.transfer(c);
                }
            } catch (Exception e) {
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : a2) {
                    queue.transfer(c);
                    System.out.println(queue.take());
                }
            } catch (Exception e) {
            }
        }, "t2").start();
    }


    public static void function4(char[] a1, char[] a2) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition(); //条件
        Condition condition2 = lock.newCondition(); //条件
        new Thread(() -> {
            lock.lock();
            try {
                for (char c : a1) {
                    System.out.println(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal(); //Wakes up one waiting thread.
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : a2) {
                    System.out.println(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal(); //Wakes up one waiting thread.
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    private static CountDownLatch latch = new CountDownLatch(1); //门栓

    //保证让字母先输出
    public static void function3(char[] a1, char[] a2) {
        Object lock = new Object();
        new Thread(() -> {
            try {
                latch.await();  //先等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                for (char c : a1) {
                    System.out.println(c);
                    try {
                        lock.notify();  //叫醒等待队列里的某一线程
                        lock.wait();  //让出锁 让自己进入等待队列中
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();

            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : a2) {
                    System.out.println(c);
                    latch.countDown(); // 减一，当减到0的时候门栓开了
                    try {
                        lock.notify();
                        lock.wait();  //让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();

            }
        }, "t2").start();
    }

    public static void function2(char[] a1, char[] a2) {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                for (char c : a1) {
                    System.out.println(c);
                    try {
                        lock.notify();  //叫醒等待队列里的某一线程
                        lock.wait();  //让出锁 让自己进入等待队列中
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();

            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : a2) {
                    System.out.println(c);
                    try {
                        lock.notify();
                        lock.wait();  //让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();

            }
        }, "t2").start();
    }


    public static void function1(char[] a1, char[] a2) {
        t1 = new Thread(() -> {
            for (char c : a1) {
                System.out.println(c);
                LockSupport.unpark(t2);  //唤醒t2
                LockSupport.park();  //t1 阻塞
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : a2) {
                LockSupport.park();  //t2 阻塞  保证t1先执行
                System.out.println(c);
                LockSupport.unpark(t1);  //唤醒t1
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
