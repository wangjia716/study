package com.example.study.semaphore;

import com.example.study.concurrent.ResultTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public class SemaphoreOperation {

    private static final int MAX_PERMITS = 5;

    private static Semaphore semaphore = new Semaphore(MAX_PERMITS, false);

//    private MyTask myTask;

    public Object getNextItem() throws Exception {
        int permits = 5;
//        semaphore.acquire(permits);

//        int threads = 10;
//        for (int i = 0; i < threads; i++) {
//            int tmp = i;
//            FutureTask<Object> futureTask = new FutureTask<>(() -> new MyTask().getString(tmp));
//            Thread thread = new Thread(futureTask);
//            System.out.println("-----i:" + i);
//            if (semaphore.tryAcquire()) {
//                thread.start();
//            }
//        }
        return "result";
    }

    public static void main(String[] args) {
        List<FutureTask<Object>> result = new ArrayList<FutureTask<Object>>();
        int threads = 10;
        for (int i = 0; i < threads; i++) {
            int tmp = i;
            FutureTask<Object> futureTask = new FutureTask<>(() -> new MyTask().getString(tmp));
            Thread thread = new Thread(futureTask);
//            try {
//                Thread thread = new Thread(futureTask);
//                semaphore.acquire();
//                thread.start();
//                result.add(futureTask);
////                System.out.println("release permit, i:" + i);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            if (semaphore.tryAcquire()) {
                thread.start();
                semaphore.release();
                System.out.println("release semaphone, i:" + i);
            } else {
                System.out.println("not acquire semaphore, i:" + i);
            }
        }
//        for (int i = 0; i < threads;i++) {
//            System.out.println("result:"+result.get(i) + ",i:"+i);
////            if (semaphore.release()) {
////
////            }
//            semaphore.release();
//        }
        semaphore.release(5);
        System.out.println("result");
    }



}
