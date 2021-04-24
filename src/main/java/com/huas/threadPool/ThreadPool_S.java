package com.huas.threadPool;

import java.util.concurrent.*;

/**
 * 1.AbortPolicy 满了就抛异常 java.util.concurrent.RejectedExecutionException
 * 2.CallerRunsPolicy 交给main线程执行
 * 3.DiscardPolicy 直接丢弃线程
 * 4.DiscardOldestPolicy 取代最老的线程,代替最老的线程的位置执行
 */
public class ThreadPool_S {
    public static void main(String[] args) {
        ExecutorService service  =new ThreadPoolExecutor(2,5,2, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),
                 new ThreadPoolExecutor.DiscardOldestPolicy());

        try{
            for (int i = 0; i < 9; i++) {
                service.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t => 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }
}
