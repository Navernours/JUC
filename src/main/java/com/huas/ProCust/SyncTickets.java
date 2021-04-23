package com.huas.ProCust;

class Ticket {
    private Integer number = 50;

    public synchronized void sale(){

        if(number>0){
        System.out.println(Thread.currentThread().getName() + "\t 卖票成功" + "还剩余" + (--number) + "张票");
    }
    }
}

public class SyncTickets {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                ticket.sale();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                ticket.sale();
            }
        },"BBB").start();

        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                ticket.sale();
            }
        },"CCC").start();
    }
}
