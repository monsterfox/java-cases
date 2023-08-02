package com.foxbill.pattern.factory.simple;

public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉！");
    }
}
