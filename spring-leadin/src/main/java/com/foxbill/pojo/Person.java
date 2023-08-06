package com.foxbill.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 理解Spring的控制反转
 */
public class Person {
    String name;
    Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public static void main(String[] args) {
        Vehicle vehicle = null;
        /*
            首先，我们需要一个交通工具。
            那交通工具哪来呢？两种方式：
            方式1:自己创建交通工具对象（传统方式：强耦合）
            方式2:从Spring容器中获取一个交通工具对象（IoC方式：弱耦合）
         */
        //方式1: 自己创建
        //vehicle = new Car();

        //方式2：容器创建，然后我们取用。此时，对象的创建权交给了容器，这就是控制反转，即IoC(Inversion of Controll)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        vehicle = (Vehicle) ctx.getBean("v1");

        //创建一个人，即Person类的对象（同样：Person对象，也可以被Spring容器管理）
        Person person = new Person();
        person.name = "张三"; //属性赋值
        person.vehicle = vehicle;//属性赋值

        System.out.println(person.name + "使用" + person.vehicle.name +"出行");

    }
}
