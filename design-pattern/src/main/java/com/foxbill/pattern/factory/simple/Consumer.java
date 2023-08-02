package com.foxbill.pattern.factory.simple;

public class Consumer {
    public static void main(String[] args) {
        //原始方式：需要一辆车，我们需要自己去创建
        /*
        Car wuLing = new WuLing();
        Car tesla = new Tesla();
        */

        //简单工厂模式：需要一辆车，我们不需要自己创建，车应该由车工厂来创建
        Car wuLing = CarFactory.getCar("五菱");
        Car tesla = CarFactory.getCar("特斯拉");


        wuLing.name();
        tesla.name();

    }
}
