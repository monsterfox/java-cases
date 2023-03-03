package com.foxbill.test;

import com.foxbill.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAspectjTest {
    /**
     * 环绕通知
     */
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) ctx.getBean("someService");//基于Aspectj 获取的是自动生成的代理对象
        System.out.println(someService.getClass().getName());//com.sun.proxy.$Proxy6

        //调用目标方法，实质上是调用了切面类中的通知方法，包括返回值，也是通知方法的返回值。（增强方法实际上拦截了目标方法的执行）
        String ret = someService.doAround("李四", 20);
        System.out.println("目标方法返回值：" + ret);
    }
}
