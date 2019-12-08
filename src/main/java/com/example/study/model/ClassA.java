package com.example.study.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

public class ClassA {

    static {
        System.out.println("执行静态代码块");
    }

    private static String staticStr = getStaticStr();

    @Setter
    @Getter
    private Integer id;

    Integer pkgAccess;

    @Setter
    public String pubAccess;

    @Setter
    private Double priAccess;

    @Setter
    protected Boolean proAccess;

    public String getPubAccess() {
        return pubAccess;
    }

    Integer getPkgAccess() {
        return pkgAccess;
    }

    private Double getPriAccess() {
        return priAccess;
    }

    protected Boolean getProAccess() {
        return proAccess;
    }

    private static String getStaticStr() {
        System.out.println("赋值静态变量");
        return "静态变量";
    }

//    public static void main(String[] args) {
//        int[] a = new int[2];
//        Map<Integer, Integer> map = new HashMap<>();
//        Set<Integer> b = new HashSet<>();
//        Integer result = ;
//        map.containsKey()
//        List<ClassA> classAList = new ArrayList<>();
//        ClassA classA = new ClassA();
//        classA.setId(1);
//        classA.setPubAccess("a");
//        classA.setProAccess(Boolean.TRUE);
//        classAList.add(classA);
//
//        ClassA classA1 = new ClassA();
//        classA1.setId(2);
//        classA1.setPubAccess("b");
//        classA1.setProAccess(Boolean.TRUE);
//        classAList.add(classA1);
//
//        ClassA classA2 = new ClassA();
//        classA2.setId(3);
//        classA2.setPubAccess("b");
//        classA2.setProAccess(Boolean.FALSE);
//
//        List<Integer> ids = classAList.stream().filter(classA3 -> classA3.getPubAccess().equals("b")).filter(classA3 -> classA3.getProAccess().equals(Boolean.TRUE)).map(ClassA::getId).collect(Collectors.toList());
//        System.out.println(ids);
//
//    }
}
