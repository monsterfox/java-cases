package com.foxbill.handle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {
    /**
     * @Around 环绕通知
     *      属性：value:切入点表达式
     *      位置：在方法定义上面
     *
     * @param pjp 相当于反射中的Method
     *            作用：执行目标方法，相当于method.invoke()
     * @return 表示 调用目标方法希望得到的执行结果（不一定是目标方法自己的返回值）
     *
     * @throws Throwable
     *
     *  特点：
     *  1.在目标方法的前和后都能增强功能
     *  2.控制目标方法是否执行
     *  3.修改目标方法的执行结果
     */
    @Around(value = "execution(* *..SomeServiceImpl.doAround(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        //增强功能-前
        System.out.println("环绕通知：在目标方法之前执行的，例如输出日志");
        //执行目标方法的调用，等同于method.invoke(target,args)
        obj = pjp.proceed();
        //增强功能-后
        System.out.println("环绕通知：在目标方法之后执行的，例如处理事务");
        return obj + ":myAround";
    }
}
