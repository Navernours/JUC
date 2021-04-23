package com.huas.ManySync;

import java.util.concurrent.TimeUnit;

class Phone1{

    public synchronized void SendMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }
    public synchronized void Call(){
        System.out.println("打电话");
    }
}

/**
 * 只有一个phone对象，先拿到先执行
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone1 phone =new Phone1();

        new Thread(()->{
            phone.Call();
        }).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            try {
                phone.SendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
