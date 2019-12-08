package com.example.study.model;

public class ClassB {

    public void test() {
        ClassA classA = new ClassA();
        Integer a = classA.pkgAccess;

        Boolean pro = classA.proAccess;

        ExtendClassA extendClassA = new ExtendClassA();

    }




}
