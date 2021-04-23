package com.huas.ManySync;

import java.util.concurrent.TimeUnit;

class Phone5{

    public static synchronized void SendMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }
    public synchronized void Call(){
        System.out.println("打电话");
    }
}

/**
 * 一个普通同步，一个静态同步，普通的先执行
 */
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Phone5 phone =new Phone5();

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
