package com.foxbill.pattern.factory.simple;

/**
 * 简单工厂模式/静态工厂模式
 *  增加一个新的产品，如果不修改代码，做不到！
 *      即：不满足开闭原则
 *  比如：增加一个新的车型:大众
 *      需要在工厂类中的代码逻辑中，添加判断代码
 */
public class CarFactory {
    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new WuLing();
        }else if(car.equals("特斯拉")){
            return new Tesla();
        }else {
            return null;
        }
    }
}
