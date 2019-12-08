package com.example.study.model.hash;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

public class HashFunction {

    public static void main(String[] args) {
        String name = "我要测试MD5算法啦";
        System.out.println(DigestUtils.md5DigestAsHex(name.getBytes()));

        String test = "我要测试MD5算法啦!";
        System.out.println(DigestUtils.md5DigestAsHex(test.getBytes()));

//        MessageDigest sha = MessageDigest.getInstance("SHA");


    }
}
