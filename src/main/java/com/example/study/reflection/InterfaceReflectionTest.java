package com.example.study.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InterfaceReflectionTest {

    interface InterfaceTest {
        int CONST_VARIABLE = 2;
        void method();
    }

    public static void main(String[] args) {
        try {
            Class obj = InterfaceTest.class;
            Field variable  = obj.getField("CONST_VARIABLE");
            System.out.println(Modifier.toString(variable.getModifiers()));

            Method method = obj.getMethod("method");
            System.out.println(Modifier.toString(method.getModifiers()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
