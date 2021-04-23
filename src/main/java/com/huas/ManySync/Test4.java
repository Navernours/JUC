package com.huas.ManySync;

import java.util.concurrent.TimeUnit;

class Phone4{

    public static synchronized void SendMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }
    public static synchronized void Call(){
        System.out.println("打电话");
    }
}

/**
 * 同步静态方法，按序执行即先拿到锁的先执行
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Phone4 phone =new Phone4();
        new Thread(()->{
            try {
                phone.SendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone.Call();
        }).start();


    }
}
