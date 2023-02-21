package com.foxbill.spring5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void testAdd(){
        /*1.原始方式 - new ：耦合度高*/

        /*
        User user = new User();
        user.addUser();
        */

        /*2.Spring方式创建对象 - 注入*/
        //1.加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean01.xml");

        //2.获取配置创建的对象
        User user = context.getBean("user",User.class);
        user.addUser();
    }
}
