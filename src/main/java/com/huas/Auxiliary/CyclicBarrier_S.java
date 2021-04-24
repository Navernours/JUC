package com.huas.Auxiliary;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier_S {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("神龙出现");
        });
        for (int i = 0; i < 7; i++) {
            final int temp =i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() +
                        "\t 收集一颗龙珠" + ",还剩" + (7-temp) + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
