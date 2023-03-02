package com.foxbill.service.impl;

import com.foxbill.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        doLog();
        System.out.println("执行业务方法doSome");
        doTrans();
    }

    @Override
    public void doOther() {
        doLog();
        System.out.println("执行业务方法doOther");
        doTrans();
    }

    public void doLog(){
        System.out.println("非业务功能，日志功能：在方法开始时输出日志");
    }

    public void doTrans(){
        System.out.println("非业务功能，事务功能：在业务方法执行之后，加入事务");
    }
}
