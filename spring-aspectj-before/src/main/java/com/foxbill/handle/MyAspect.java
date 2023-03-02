package com.foxbill.handle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {
/*//    @Before("execution(public void com.foxbill.service.impl.SomeServiceImpl.doSome())")
    @Before("execution(* *..SomeServiceImpl.do*(..))") //切入点表达式的变化形式
    public void myBefore(){
        System.out.println("前置通知，切面的功能，在目标方法之前先执行：" + new Date());
    }*/


    /**
     * JoinPoint 连接点
     * 通过JoinPoint可以获取目标方法相关信息
     *
     * @param jp
     */
    @Before("execution(* *..SomeServiceImpl.doSome(..))") //切入点表达式的变化形式
    public void myBefore(JoinPoint jp){
        System.out.println("===============================");
        System.out.println("连接点的方法的定义："+jp.getSignature());
        System.out.println("连接点的方法的参数个数："+jp.getArgs().length);
        System.out.println(jp.getSignature().getName()); //方法名
        //方法参数的信息
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("前置通知，切面的功能，在目标方法之前先执行：" + new Date());
    }


    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "result")
    public void myAfterReturning(Object result){
        //修改目标方法的执行结果
        if(result != null){
            String s = (String) result;
            result = s.toUpperCase();
        }
        System.out.println("后置通知：在目标方法之后执行的功能增强，例如执行事务处理（切面）" + result);
    }
}
