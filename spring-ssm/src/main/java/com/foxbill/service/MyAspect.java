package com.foxbill.service;

import org.aspectj.lang.ProceedingJoinPoint;
//负责计时的切面类
public class MyAspect {

    /*
        环绕通知，如果返回值void,不写返回值可能会报错
     */
    public Object beforeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start:" + start);
        //执行目标
        Object obj = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("end:" + end);

        System.out.println("AOP===============耗时" + (end - start) + "毫秒===============AOP");
        return obj;
    }
}
