/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author fuzf
 * @Date 2022/6/9:23:33
 * @Description:
 */


public class TransferQueueMain {

    static LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Producer producer = new TransferQueueMain().new Producer();
        Consumer consumer = new TransferQueueMain().new Consumer();
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.shutdown();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 4; i++) {
                    System.out.println("producer is waiting ...");
                    /**
                     * transfer(E e)若当前存在一个正在等待获取的消费者线程，即立刻将e移交之；
                     * 否则将元素e插入到队列尾部，并且当前线程进入阻塞状态，直到有消费者线程取走该元素。
                     *
                     *
                     */
                    queue.transfer("pro" + i);
                    System.out.println("producer transfered pro" + i);
                }
            } catch (Exception e) {

            }
        }
    }


    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("consumer is waiting to take ...");
                    if (i == 2) {
                        Thread.sleep(3000);

                        System.out.println(queue.isEmpty());
                        System.out.println(queue.getWaitingConsumerCount());
                    } else {
                        String take = queue.take();
                        System.out.println("consumer received " + take);
                    }

                }
            } catch (Exception e) {

            }
        }
    }


}
