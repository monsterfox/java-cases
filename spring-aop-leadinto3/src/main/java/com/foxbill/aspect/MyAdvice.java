package com.foxbill.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void doLog(){
        System.out.println("非业务功能，日志功能：在方法开始时输出日志");
    }

    public void doTrans(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("非业务功能，事务功能：在业务方法执行之前，开启事务");
        pjp.proceed();
        System.out.println("非业务功能，事务功能：在业务方法执行之后，提交事务");
    }
}
