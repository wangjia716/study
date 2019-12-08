package com.example.study.model.ObjectStream;

import java.io.*;
import java.util.Properties;

public class StudyStream {

    public static byte[] readObject(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        return byteArrayOutputStream.toByteArray();
    }

//    public static void main(String[] args) throws Exception{
//        String a = "test";
//        System.out.println(readObject(a));
//
//        Stats
//    }
}
