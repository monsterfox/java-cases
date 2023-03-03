package com.foxbill.service.impl;

import com.foxbill.service.SomeService;


public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,int age) {
        System.out.println("执行业务方法doSome");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("执行业务方法doOther"+":"+name+","+age);
        return "abcd";
    }

    @Override
    public String doAround(String name, int age) {
        System.out.println("执行业务方法doAround");
        return "doAround";
    }
}
