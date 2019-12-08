package com.example.study.serviceClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadLocalServiceTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private ThreadLocalService threadLocalService;

    @Test
    public void threadLocalValue() {
        String a= "test";

        System.out.printf("finlally:"+Thread.currentThread().getId()+":"+threadLocalService.threadLocalValue(a) + "\n\t");
    }
}