/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

/**
 * @Author fuzf
 * @Date 2022/6/13:15:40
 * @Description:
 */

public class InterruptTestMain {

    public static void main(String[] args) {
//        based();
        interruptFunction();
    }

    public static void based() {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("0000");
                    }
                }
        );
//        thread.start();

        thread.interrupt();//设置线程中断标志，作用是中断此线程（不一定是当前线程，而是只调用该方法的线程实例代表的线程）
        boolean interrupted = thread.isInterrupted();//只检测中断;  作用于实例所代表的线程;作用是只测试此线程是否被中断 ，不清除中断状态
        System.out.println(interrupted);

    }

    public static void interruptFunction() {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(6000);
                            System.out.println("0000");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        thread.start();
        thread.interrupt();

    }
}
