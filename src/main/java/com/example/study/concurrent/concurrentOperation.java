package com.example.study.concurrent;


import java.util.concurrent.*;

public class concurrentOperation {

    public static void main(String[] args) {

        try {
            FutureTask<Object> objectFuture = new FutureTask<>(new ResultTask());

            new Thread(objectFuture).start();

            Object object = objectFuture.get();
            System.out.println("before");
//            Object object = objectFuture.get();
            System.out.println("after");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
