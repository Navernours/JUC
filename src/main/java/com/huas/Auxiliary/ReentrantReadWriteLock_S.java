package com.huas.Auxiliary;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCaChe {
    volatile Map<String,String> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "写入\t =>"+"\t"+value);
            map.put(key,value);
            System.out.println("写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String kye){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读入\t =>" + "\t" + map.get(kye));
            System.out.println("读入成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLock_S {
    public static void main(String[] args) {
        MyCaChe myCaChe = new MyCaChe();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCaChe.put(String.valueOf(finalI),String.valueOf(finalI));
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCaChe.get(String.valueOf(finalI));
            }).start();
        }
    }
}
