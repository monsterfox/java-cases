package com.foxbill.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAdvice {

    public void doLog(){
        System.out.println("非业务功能，日志功能：在方法开始时输出日志");
    }

    @Around(value = "execution(* com.foxbill.service.impl.SomeServiceImpl.*(..))")
    public void doTrans(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("非业务功能，事务功能：在业务方法执行之前，开启事务");
        pjp.proceed();
        System.out.println("非业务功能，事务功能：在业务方法执行之后，提交事务");
    }
}
