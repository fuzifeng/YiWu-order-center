package threads;

import java.util.concurrent.CompletableFuture;

public class SingleThreadMain {


    public static void main(String[] args) {
        test1();

    }

    public static void test1() {
        Thread t1 = new Thread(() -> {
            System.out.println("thread1");
        }, "t1");


        Thread t2 = new Thread(() -> {
            System.out.println("thread2");
        }, "t2");

        Thread t3 = new Thread(() -> {
            System.out.println("thread3");
        }, "t3");

        Thread t4 = new Thread(() -> {
            System.out.println("thread4");
        }, "t4");
        Thread t5 = new Thread(() -> {
            System.out.println("thread5");
        }, "t5");
        Thread t6 = new Thread(() -> {
            System.out.println("thread6");
        }, "t6");
        Thread t7 = new Thread(() -> {
            System.out.println("thread7");
        }, "t7");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();


        //这个很垃圾，网上讲的没有用
        CompletableFuture.runAsync(() -> t1.start())
                .thenRun(() -> t2.start())
                .thenRun(() -> t3.start())
                .thenRun(() -> t4.start())
                .thenRun(() -> t5.start())
                .thenRun(() -> t6.start())
                .thenRun(() -> t7.start());

    }
}
