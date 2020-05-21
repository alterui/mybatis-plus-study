package com.lr.jooq.application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2020/5/15 4:34 下午
 */
public class Application {
    public static void main(String[] args) {
        System.out.println(get());
    }
    public static List get() {
        List<Integer> list = new ArrayList<>();
        list.add(200);
        System.out.println(list.contains(19));


        System.out.println(list.contains(200));
        return null;
    }
}
