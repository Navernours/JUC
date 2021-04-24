package com.huas.callable;

import java.nio.channels.NotYetBoundException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable实现了");
        return "1024";
    }
}

public class Callable_S {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
