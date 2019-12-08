package com.example.study.innerClass;

public class OuterClass {

    class InnerClass {
        public OuterClass createOuterClass() {
            return OuterClass.this;
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
}
