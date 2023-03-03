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
    @After(value = "mypt()")
    public void myAfter(){
        System.out.println("最终通知:总是会被执行的方法");
    }


    /**
     * @Pointcut: 定义和管理切入点，不是通知注解
     *      属性：value 切入点表达式
     *      位置：在一个自定义方法的上面，这个方法看作是切入点表达式的别名。
     *          其他的通知注解中国，可以使用方法名称，就表示使用这个切入点表达式。
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doAfter(..))")
    private void mypt(){
        //无需代码
    }
}
