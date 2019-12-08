package com.example.study.serviceClass;

import com.example.study.model.ClassA;
import com.example.study.model.ExtendClassA;
import com.example.study.service.IStudy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudyTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private List<IStudy> studyList;

    @Test
    public void testStudy() {
        for (IStudy iStudy : studyList) {
            System.out.println(iStudy.run("sleep"));
        }
    }
}
