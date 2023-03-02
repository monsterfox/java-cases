package com.foxbill.handle;

import com.foxbill.service.SomeService;
import com.foxbill.service.impl.SomeServiceImpl;
import org.springframework.stereotype.Component;

/**
 * 自己定义的代理
 */
@Component
public class ServiceProxy implements SomeService{

    SomeService target = new SomeServiceImpl();
    MyAspect aspect = new MyAspect();

    @Override
    public void doSome(){
        aspect.myBefore();
        target.doSome();
    }

    @Override
    public void doOther() {
        aspect.myBefore();
        target.doOther();
    }
}
