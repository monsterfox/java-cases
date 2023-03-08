package com.foxbill.service.impl;

import com.foxbill.proxy.ServiceProxy;
import com.foxbill.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SomeServiceImplTest {

    @Test
    public void test01() {
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02() {
        SomeService service = new ServiceProxy();
        service.doSome();
    }
}