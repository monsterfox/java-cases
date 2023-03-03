package com.foxbill.service;

public interface SomeService {
    void doSome(String name,int age);//用于演示前置通知
    String doOther(String name,int age);//用于演示后置通知
    String doAround(String name,int age);//用于演示环绕通知
    void doThrowing(); //用于演示异常通知
    void doAfter(); //用于演示最终通知
}
