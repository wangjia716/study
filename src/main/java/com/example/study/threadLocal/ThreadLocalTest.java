package com.example.study.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest implements Runnable {



    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
//            Thread thread = new RunnableTask("thread1");
//            threadLocal.set(String.valueOf(Thread.currentThread().getId()));
//            theadIdLocal.set(Thread.currentThread().getId());
//            testId.set(999L);
//            ThreadLocalTest runableTask = new ThreadLocalTest();
//            Thread thread = new Thread(runableTask);
//            thread.start();
//            System.out.println("main process:" + threadLocal.get());
//            System.out.println("threadId of mainProcess:" + theadIdLocal.get());
//            System.out.println("testId of mainProcess:" + testId.get());
            for (int i=0;i < 5;i++) {
                executorService.submit(new ThreadLocalTest());
            }
            TimeUnit.MILLISECONDS.sleep(1000);
            executorService.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        asynOperation();
    }

//    class RunnableTask implements Runnable {
//
//        @Override
//        public void run() {
//            asynOperation();
//        }
//    }

    private void asynOperation() {
        ThreadLocalHolder.increment();
        System.out.println("test:" + toString());
    }

    public String toString() {
        return "id:" + Thread.currentThread().getId() + ",threadLocal:" + String.valueOf(ThreadLocalHolder.get());
    }
}

