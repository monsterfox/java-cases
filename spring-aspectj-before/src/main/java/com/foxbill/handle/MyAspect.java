package com.foxbill.handle;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {
//    @Before("execution(public void com.foxbill.service.impl.SomeServiceImpl.doSome())")

    @Before("execution(* *..SomeServiceImpl.do*(..))") //切入点表达式的变化形式
    public void myBefore(){
        System.out.println("前置通知，切面的功能，在目标方法之前先执行：" + new Date());
    }
}
