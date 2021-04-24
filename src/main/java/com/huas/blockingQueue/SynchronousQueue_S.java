package com.huas.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * 一个put对应一个take
 */
public class SynchronousQueue_S {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "put\t=>\tput =>1");
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + "put\t=>\tput =>2");
                blockingQueue.put(2);
                System.out.println(Thread.currentThread().getName() + "put\t=>\tput =>3");
                blockingQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "take\t =>" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "take\t =>" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "take\t =>" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
