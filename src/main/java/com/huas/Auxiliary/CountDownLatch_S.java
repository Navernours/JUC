package com.huas.Auxiliary;

import java.util.concurrent.CountDownLatch;

/**
 * 知道CountDownLatch的count减完了,才往下接着进行.
 */
public class CountDownLatch_S {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        System.out.println("门开着");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "\t =>出门");
            }).start();
        }
        countDownLatch.await(); //count归零，在向下执行
        System.out.println("门被关了");
    }
}
