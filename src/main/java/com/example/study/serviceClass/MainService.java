package com.example.study.serviceClass;

import com.example.study.model.ClassA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class MainService {

    @Resource
    private ThreadLocalService threadLocalService;

    public void run() {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("a");

        System.out.printf("---before null", stringThreadLocal.get());
        String s = threadLocalService.threadLocalValue("a");


    }

    public static void main(String[] args) throws Exception {
//        int a = 0x2f;
//        System.out.println(a);
//        System.out.println("a:"+Integer.toBinaryString(a));
//
//        int b = 0177;
//        System.out.println("b1:" + b);
//        System.out.println("b:" + Integer.toBinaryString(b));
//
//        long c = 1783785959;
//        System.out.println(c);
//
//        float f4 = 1e-43f;
//        double d4 = 1e-43;
//        System.out.println(f4);
//        System.out.println(d4);
//
//
//
//        int i1 = 1;
//        int i2 = 0;
//        int i3 = 2;
//        System.out.println(i1&i2);
//        System.out.println(i1|i2);
//        System.out.println(i1^i2);
//        System.out.println(Integer.toBinaryString(i1));
//        System.out.println(Integer.toBinaryString(~i1));
//
//        int i4 = -2;
//        System.out.println(Integer.toBinaryString(i4));

//        Class aClass = Class.forName("com.example.study.model.ClassA");
//        System.out.println(aClass);
//        Class bClass = ClassLoader.getSystemClassLoader().loadClass("com.example.study.model.ClassA");
//        System.out.println(bClass);
//        System.out.println(aClass.equals(bClass));
//
//        System.out.println(ClassLoader.getSystemClassLoader());
//        System.out.println(ClassLoader.getSystemClassLoader().getParent());
//        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

//        ClassLoader myClassloader = new ClassLoader() {
//            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                try {
//                    String filename = name.substring(name.lastIndexOf(".") + 1)
//                            + ".class";
//                    InputStream inputStream = getResourceAsStream(filename);
//                    if (inputStream == null) {
//                        return super.loadClass(name);
//                    }
//                    byte[] a = new byte[inputStream.available()];
//                    inputStream.read(a);
//                    return defineClass(name, a, 0, a.length);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException();
//                }
//            }
//        };
//
//        Class aclass= myClassloader.loadClass("com.example.study.serviceClass.MainService");
//        Object mainService = aclass.newInstance();
//        System.out.println(aclass);
//        System.out.println(mainService);
//        System.out.println(mainService instanceof com.example.study.serviceClass.MainService);
        String fileName = "application"+".properties";
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
        properties.load(inputStream);
        System.out.println(properties.getProperty("test"));
        System.out.println(properties.get("test"));
        System.out.println(properties);

    }
}
