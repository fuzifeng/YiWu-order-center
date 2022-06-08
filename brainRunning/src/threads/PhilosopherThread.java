/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

/**
 * @Author fuzf
 * @Date 2022/6/7:23:23
 * @Description:
 */

public class PhilosopherThread extends Thread {

    private Chopsticks left;
    private Chopsticks right;
    private int index;

    public PhilosopherThread(Chopsticks left, Chopsticks right, int index) {
        this.left = left;
        this.right = right;
        this.index = index;
    }


    @Override
    public void run() {
        if (index % 5 != 0) {
            synchronized (left) {
                try {
                    Thread.sleep(1000);
//                System.out.println(index + "等待获取left");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index + "等待获取right");
                synchronized (right) {
                    System.out.println(index + "获取right，开始吃饭");
                }
            }
        } else {
            synchronized (right) {
                try {
                    Thread.sleep(1000);
//                System.out.println(index + "等待获取left");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index + "等待获取right");
                synchronized (left) {
                    System.out.println(index + "获取right，开始吃饭");
                }
            }
        }

    }

    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks();
        Chopsticks c2 = new Chopsticks();
        Chopsticks c3 = new Chopsticks();
        Chopsticks c4 = new Chopsticks();
        Chopsticks c5 = new Chopsticks();

        PhilosopherThread p1 = new PhilosopherThread(c1,c2,1);
        PhilosopherThread p2 = new PhilosopherThread(c2,c3,2);
        PhilosopherThread p3 = new PhilosopherThread(c3,c4,3);
        PhilosopherThread p4 = new PhilosopherThread(c4,c5,4);
        PhilosopherThread p5 = new PhilosopherThread(c5,c1,5);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }



}

class Chopsticks{}
