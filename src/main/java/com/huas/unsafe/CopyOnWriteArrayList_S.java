package com.huas.unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 解决方案
 * 1.  List<String> list = Collections.synchronizedList(new ArrayList<>());
 * 2.  List<String> list = new CopyOnWriteArrayList<>();
 */
public class CopyOnWriteArrayList_S {
    public static void main(String[] args) {
      //  List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }
    }
}
