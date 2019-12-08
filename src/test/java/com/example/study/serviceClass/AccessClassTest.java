package com.example.study.serviceClass;

import com.example.study.model.ClassA;
import com.example.study.model.ExtendClassA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccessClassTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testClassA() {
        ClassA classA = new ExtendClassA();
        Boolean proAccess = ((ExtendClassA) classA).getProVariable();
    }
}
