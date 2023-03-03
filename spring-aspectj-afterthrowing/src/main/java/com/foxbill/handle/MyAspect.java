package com.foxbill.handle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAspect {
    //定义方法，表示切面的具体功能
    /*
        异常通知方法的定义
        1)方法是public
        2)方法没有返回值，是void
        3)方法名称自定义
        4)方法有参数是Exception
     */

    /**
     * @AfterThrowing 异常通知
     *
     * @param ex
     */
    @AfterThrowing(value = "execution(* *..doThrowing(..))",throwing = "ex")
    public void myAfterThrowing(Exception ex){
        //把异常发生的时间，位置，原因记录到数据库，日志文件等等
        //可以在异常发生时，把异常信息通过短信，邮件发送给开发人员
        System.out.println("异常通知：在目标方法抛出异常时执行的，异常原因：" + ex.getMessage());
    }
}
