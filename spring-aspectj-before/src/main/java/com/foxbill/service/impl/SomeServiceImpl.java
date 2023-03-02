package com.foxbill.service.impl;

import com.foxbill.service.SomeService;


public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");
    }
}
