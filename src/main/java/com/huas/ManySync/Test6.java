package com.huas.ManySync;

import java.util.concurrent.TimeUnit;

class Phone6{

    public static synchronized void SendMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }
    public synchronized void Call(){
        System.out.println("打电话");
    }
}

/**
 * 两个锁对象，一个同步方法，一个静态同步方法，普通同步先执行
 */
public class Test6 {
    public static void main(String[] args) throws InterruptedException {
        Phone6 phone =new Phone6();
        Phone6 phone1 =new Phone6();
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
