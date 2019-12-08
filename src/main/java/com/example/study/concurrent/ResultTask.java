package com.example.study.concurrent;

import java.util.concurrent.Callable;

public class ResultTask implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        System.out.println("callable");
        return "test callable";
    }
}
