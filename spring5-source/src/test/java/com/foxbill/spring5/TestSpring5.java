package com.foxbill.spring5;

import com.foxbill.spring5.pojo.School;
import com.foxbill.spring5.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {

    /**
     * 1.Spring容器创建的同时，创建所有的bean.
     * 2.创建bean时，默认调用无参构造方法.
     */
    @Test
    public void test01(){
        /*1.原始方式 - new ：耦合度高*/

        /*2.Spring方式创建对象 - 注入*/
        //1.加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean01.xml");

        //2.获取配置创建的对象
        SomeService someService = (SomeService) context.getBean("someService");

        someService.doSome();
    }

    /**
     * DI 注入方式：
     * 1）set注入，也叫设值注入
     *
     * 2）构造注入
     */
    @Test
    public void test02(){
        //1.加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean01.xml");

        School mySchool = (School) context.getBean("mySchool");
        System.out.println(mySchool);
    }
}
