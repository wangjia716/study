package com.example.study.model.pkg;

import com.example.study.model.ClassA;

public class ClassC {

    public void test() {
        ClassA classA = new ClassA();
        ExtendClassA2 extendClassA2 = new ExtendClassA2();
        String c = extendClassA2.pubAccess;
    }
}
