package com.foxbill.handle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAspect {
    //定义方法，表示切面的具体功能
    /*
        最终通知方法的定义
        1)方法是public
        2)方法没有返回值，是void
        3)方法名称自定义
        4)方法没有参数
     */

    /**
     * @After 最终通知
     *
     *  特点：
     *  1. 在目标方法之后执行
     *  2.总是会被执行
     *  3.可以用来做程序最后的收尾工作，例如清除临时数据，变量，清理内存
     */
    @After(value = "execution(* *..SomeServiceImpl.doAfter(..))")
    public void myAfter(){
        System.out.println("最终通知:总是会被执行的方法");
    }
}
