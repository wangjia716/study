package com.example.study.threadLocal;

import java.util.Random;

public class ThreadLocalHolder {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void increment() {
        if (threadLocal.get() == null) {
            threadLocal.set(new Random(47).nextInt(1000));
            return;
        }
        threadLocal.set(threadLocal.get() +1);
    }

    public static int get() {
        return threadLocal.get();
    }

//    @Override
//    public String toString() {
//        return "threadId:" + Thread.currentThread().getId() + ",value:" + threadLocal.get();
//    }
}
