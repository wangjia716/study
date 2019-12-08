package com.example.study.service.impl;

import com.example.study.service.IStudy;
import org.springframework.stereotype.Component;

@Component
public class StudyBImpl implements IStudy {
    @Override
    public String run(String str) {
        return "studyB:" + str;
    }
}
