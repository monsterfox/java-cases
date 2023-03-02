package com.foxbill.proxy;

import com.foxbill.service.SomeService;
import com.foxbill.service.impl.SomeServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class ServiceProxy implements SomeService{

    SomeService target = new SomeServiceImpl();

    @Override
    public void doSome(){
        System.out.println("非业务功能，日志功能：在方法开始时输出日志");
        target.doSome();
        System.out.println("非业务功能，事务功能：在业务方法执行之后，加入事务");
    }

    @Override
    public void doOther() {
        System.out.println("非业务功能，日志功能：在方法开始时输出日志");
        target.doOther();
        System.out.println("非业务功能，事务功能：在业务方法执行之后，加入事务");
    }
}
