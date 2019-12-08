package com.example.study.serviceClass;

import org.springframework.stereotype.Service;

@Service
public class ThreadLocalService {

    public String threadLocalValue(String s) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set(s);
        System.out.printf("---main thread:"+Thread.currentThread().getId()+":" + stringThreadLocal.get() + "\n\t");


        new Thread(() -> {
            stringThreadLocal.set(null);
            Thread thread = Thread.currentThread();
            System.out.printf("-----"+thread.getId() + ":"+ stringThreadLocal.get() + "\n\t");}).start();;
//        Runnable runnable1 = () -> {
//            stringThreadLocal.set(null);
//            Thread thread = Thread.currentThread();
//            System.out.printf("-----"+thread.getId() + ":"+ stringThreadLocal.get() + "\n\t");};
//        runnable1.run();

        Thread thread = new Thread(() -> {
            stringThreadLocal.set(s);
            System.out.printf("====="+Thread.currentThread().getId() + ":" + stringThreadLocal.get() + "\n\t");});
        thread.start();


        return stringThreadLocal.get();
    }
}
