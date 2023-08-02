package com.foxbill.pattern.factory.method;

public class Consumer {
    public static void main(String[] args) {
        //工厂方法模式：需要一辆车，我们不需要自己创建，找对应品牌的车工厂来创建
        //增加新车，要同时增加：车类、对应车的工厂类
        Car wuLing = new WuLingFactory().getCar();
        Car tesla = new TeslaFactory().getCar();

        wuLing.name();
        tesla.name();

        Car toyota = new ToyotaFactory().getCar();
        toyota.name();

    }
}
