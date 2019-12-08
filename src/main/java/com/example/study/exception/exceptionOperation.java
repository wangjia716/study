package com.example.study.exception;

public class exceptionOperation {

    public static void main(String[] args) {
        try {
            System.out.println("test exception!");
//            System.exit(0);
//            Runtime.getRuntime().exit(0);
            throw new RuntimeException("runtime exception happen!");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
            Runtime.getRuntime().exit(0);
        } finally {
            System.out.println("finally do");
        }
    }
}
