package com.foxbill.handle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {

    /**
     * @AfterReturnning 后置通知
     *      属性：
     *          value:切入点表达式
     *          returning：自定义变量，表示目标方法的返回值。
     *                     自定义变量名称必须和通知方法的形参名一致。
     *      位置：在方法上
     *      特点：
     *          1.在目标方法之后执行
     *          2.能获取到目标方法的执行结果
     *          3.不会影响目标方法的执行结果
     *
     *      方法的参数：
     *          Object result:表示目标方法的返回值，使用result接收目标方法的执行结果
     *          Object result = doOther();
     * @param result
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "result")
    public void myAfterReturning(Object result){
        //修改目标方法的执行结果
        if(result != null){
            String s = (String) result;
            result = s.toUpperCase();
        }
        System.out.println("后置通知：在目标方法之后执行的功能增强，例如执行事务处理（切面）");
        System.out.println("通过后置通知，修改目标方法的执行结果：" + result);
    }
}
