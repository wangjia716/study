package com.example.study.serviceClass;

import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class MainServiceTest extends MainService {

    @Resource
    private MainService mainService;

    @Test
    public void run() {
        mainService.run();
    }
}