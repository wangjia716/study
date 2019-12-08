package com.example.study.concurrent;

import com.example.study.threadLocal.ThreadLocalHolder;

public class RunableTask implements Runnable {
    @Override
    public void run() {
        asynOperation();
    }

    private void asynOperation() {
        ThreadLocalHolder.increment();
        System.out.println(toString());
    }

    public String toString() {
        return String.valueOf(ThreadLocalHolder.get());
    }
}
