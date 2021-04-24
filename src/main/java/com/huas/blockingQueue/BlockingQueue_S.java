package com.huas.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue_S {
    public static void main(String[] args) throws InterruptedException {
       // test1();
       // test2();
       // test3();
        test4();
    }

    /**
     * 超时就退出阻塞
     */
    private static void test4() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer(1, 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(2, 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(3, 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(3, 2, TimeUnit.SECONDS));
        System.out.println("==============================");
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }

    /**
     * 一直阻塞
     */
    private static void test3() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);
        System.out.println("====================");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    /**
     * 不抛异常，但有返回值
     */
    private static void test2() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(2));
        System.out.println(blockingQueue.offer(3));
        System.out.println(blockingQueue.offer(4));
        System.out.println("======================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * 抛异常
     */
    private static void test1() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add(1));
        System.out.println(blockingQueue.add(2));
        System.out.println(blockingQueue.add(3));
        System.out.println(blockingQueue.add(4));
        System.out.println("==========");
        System.out.println(blockingQueue.remove(1));
        System.out.println(blockingQueue.remove(2));
        System.out.println(blockingQueue.remove(3));
        System.out.println(blockingQueue.remove(4));
    }
}
