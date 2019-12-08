package com.example.study.service.impl;

import com.example.study.service.IStudy;
import org.springframework.stereotype.Component;

@Component
public class StudyImpl implements IStudy {
    @Override
    public String run(String str) {
        return "studyA:" + str;
    }
}
