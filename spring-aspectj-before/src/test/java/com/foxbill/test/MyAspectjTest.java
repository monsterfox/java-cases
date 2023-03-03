package com.foxbill.test;

import com.foxbill.handle.ServiceProxy;
import com.foxbill.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAspectjTest {

    /**
     * 前置通知：通过代理对象给目标对象增加切面功能
     */
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) ctx.getBean("someService");//基于Aspectj 获取的是自动生成的代理对象
        System.out.println(someService.getClass().getName());//com.sun.proxy.$Proxy6
        someService.doSome("张三",18);
    }

    /**
     * 前置通知：通过自定义代理给目标对象增加切面功能
     */
    @Test
    public void test02(){
        SomeService someService = new ServiceProxy();//创建自定义的代理对象
        System.out.println(someService.getClass().getName());
        someService.doSome("张三",18);
    }
}
