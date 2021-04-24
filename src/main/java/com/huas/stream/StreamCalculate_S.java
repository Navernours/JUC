package com.huas.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流式计算
 * 题目要求: 只能用流式代码实现!
 * 现在有5个用户!筛选:
 * 1、ID必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户!
 */
public class StreamCalculate_S {
    public static void main(String[] args) {
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(5,"e",25);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream()
                .filter(x->{return x.getId() % 2 == 0;})
                .filter(x->{return x.getAge() > 23;})
                .map(x->{return x.getName().toUpperCase();})
                .sorted((x,y)->{return x.compareTo(y);})
                .limit(1)
                .forEach(System.out::println);
    }
}
