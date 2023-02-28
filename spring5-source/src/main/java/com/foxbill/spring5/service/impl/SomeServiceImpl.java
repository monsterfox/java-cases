package com.foxbill.spring5.service.impl;

import com.foxbill.spring5.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl无参构造");
    }


    @Override
    public void doSome() {
        System.out.println("SomeServiceImpl....");
    }
}
