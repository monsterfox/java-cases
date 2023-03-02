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
    public void doSome(String name,int age){
        aspect.myBefore(null);
        target.doSome(name,age);
    }

    @Override
    public String doOther(String name, int age) {
        aspect.myBefore(null);
        return target.doOther(name,age);
    }
}
