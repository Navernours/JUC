package com.huas.ProCust;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CurrentTicket {
    private Integer number = 50;
    private Integer start = 0;

    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if(number>0){
                System.out.println(Thread.currentThread().getName() +
                        "\t 卖出了第" + ++start + "张票" +
                        ",还剩余" + --number + "张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class CurrentTickets {
    public static void main(String[] args) {
        CurrentTicket currentTicket = new CurrentTicket();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                currentTicket.sale();
            }
        },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                currentTicket.sale();
            }
        },"BBB").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                currentTicket.sale();
            }
        },"CCC").start();
    }
}
