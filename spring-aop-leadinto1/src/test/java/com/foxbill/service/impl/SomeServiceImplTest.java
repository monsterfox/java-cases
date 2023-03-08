package com.foxbill.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SomeServiceImplTest {

    @Test
    public void doService() {
        SomeServiceImpl someService = new SomeServiceImpl();
        someService.doSome();
        System.out.println("\r\n");
        someService.doOther();
    }
}