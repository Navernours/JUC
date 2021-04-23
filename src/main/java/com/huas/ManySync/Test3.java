package com.huas.ManySync;

import java.util.concurrent.TimeUnit;

class Phone3{

    public synchronized void SendMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }
    public synchronized void Call(){
        System.out.println("打电话");
    }
}

/**
 * 两个锁对象，没有延时的同步方法先执行
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Phone3 phone =new Phone3();
        Phone3 phone1 =new Phone3();
        new Thread(()->{
            try {
                phone.SendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone1.Call();
        }).start();
    }
}
