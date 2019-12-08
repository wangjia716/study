package com.example.study.memcacheLeak;

import java.util.LinkedList;

public class HeapOutException {

    public static void main(String[] args) {
        LinkedList<Object> test = new LinkedList<>();
        int i = 0;
        while (true) {
            test.add(new Object());
            i++;
        }
    }
}
