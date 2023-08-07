package com.foxbill.test;

import com.foxbill.service.SomeService;
import com.foxbill.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        SomeService someService = ctx.getBean("someService",SomeService.class);
        someService.doSome();
    }
}
