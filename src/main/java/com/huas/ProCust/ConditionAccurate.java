package com.huas.ProCust;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConditionData{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Integer number = 1;

    public void printA(){
        lock.lock();
        try{
            while(number != 1){
                condition1.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName() + "\t =>\t BBB");
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try{
            while(number != 2){
                condition2.await();
            }
            number = 3;
            System.out.println(Thread.currentThread().getName() + "\t =>\t CCC");
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            while(number != 3){
                condition3.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "\t =>\t AAA");
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ConditionAccurate {
    public static void main(String[] args) {
        ConditionData conditionData = new ConditionData();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                conditionData.printA();
            }
        },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                conditionData.printB();
            }
        },"BBB").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                conditionData.printC();
            }
        },"CCC").start();
    }
}
