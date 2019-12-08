//package com.example.study.model.stack;
//
//public class Stack {
//
//    private char[] elements;
//
//    private int length;
//
//    private int size;
//
//    public char pop() {
//        char result = elements[size-1];
//        elements[size-1] = '\0';
//        size--;
//        return result;
//    }
//
//    public char peek() {
//        return elements[size-1];
//    }
//
//    public void put(char element) {
//        elements[size] = element;
//        size++;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    Stack(int length) {
//        this.size = 0;
//        this.elements = new char[length];
//    }
//
//}
