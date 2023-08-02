package com.foxbill.test;

import com.foxbill.service.SomeService;
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
