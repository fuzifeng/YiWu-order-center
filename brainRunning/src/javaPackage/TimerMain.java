/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package javaPackage;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author fuzf
 * @Date 2022/7/2:16:26
 * @Description:
 */

public class TimerMain {

    public static void main(String[] args) {
        long delay = 1000;
        long period = 2000;
        Timer timer = new Timer();
        Alert alert = new Alert("滴滴闹钟");
        timer.schedule(alert, delay, period);
        int i = 2;
        while(true){
            Alert alarm = new Alert("闹钟" + i);
            i++;
            timer.schedule(alarm,100,10_0000);
            alarm.cancel();
            Thread.yield();
            System.out.println("已取消闹钟"+i++);
        }

//        Alert alert2 = new Alert("钉钉闹钟");
//        timer.schedule(alert2, delay, period);

    }

    static class Alert extends TimerTask {
        static ExecutorService threadPool = Executors.newCachedThreadPool();
        byte[] bytes = new byte[10*1024*1024]; //模拟业务数据
        String name;

        public Alert(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(("[" + Thread.currentThread().getName() + "]" + name + ":嘀。。。"));
            try {
                Thread.sleep(1000); //模拟闹钟执行时间，省略异常。。。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            /*threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(("[" + Thread.currentThread().getName() + "]" + name + ":嘀。。。"));
                    try {
                        Thread.sleep(1000); //模拟闹钟执行时间，省略异常。。。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });*/

        }
    }


}
