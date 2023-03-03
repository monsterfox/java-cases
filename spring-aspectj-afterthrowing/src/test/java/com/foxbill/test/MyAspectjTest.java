package com.foxbill.test;

import com.foxbill.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAspectjTest {
    /**
     * 异常通知
     */
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) ctx.getBean("someService");//基于Aspectj 获取的是自动生成的代理对象
        System.out.println(someService.getClass().getName());//com.sun.proxy.$Proxy6

        someService.doThrowing();

    }
}
