package com.example.study.semaphore;

public class MyTask {

    public String getString(int i) {
        System.out.println("线程："+i);

        return String.valueOf(i);
    }
}
