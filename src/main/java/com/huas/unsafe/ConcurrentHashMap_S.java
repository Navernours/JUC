package com.huas.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 解决方案
 * 1.  Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
 * 2.  Map<String,String> map = new ConcurrentHashMap<>();
 */
public class ConcurrentHashMap_S {
    public static void main(String[] args) {
       // Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            }).start();
        }
    }
}
