package com.huas.ManySync;
import java.util.concurrent.TimeUnit;

class Phone2{

    public synchronized void SendMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }
    public synchronized void Call(){
        System.out.println("打电话");
    }
    public void Sleep(){
        System.out.println("睡眠");
    }
}

/**
 * 添加了普通方法，普通方法先执行,同步的先拿到先执行
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Phone2 phone =new Phone2();

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

        new Thread(()->{
            phone.Sleep();
        }).start();
    }
}
