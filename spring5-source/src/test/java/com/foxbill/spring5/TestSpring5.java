package com.foxbill.spring5;

import com.foxbill.spring5.pojo.Leader;
import com.foxbill.spring5.pojo.School;
import com.foxbill.spring5.pojo.Student;
import com.foxbill.spring5.pojo.Teacher;
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
    public void test01() {
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
     * 基本数据类型注入 value
     * 引用数据类型注入 ref
     */
    @Test
    public void test02() {
        //1.加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean01.xml");

        School mySchool = (School) context.getBean("mySchool");
        System.out.println(mySchool);

        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    /**
     * DI 注入方式：
     * 2）构造注入
     * （1）普通类型属性  value  （2）引用类型属性  ref
     */
    @Test
    public void test03() {
        //1.加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean01.xml");

        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher);
    }

    /**
     * 引用类型自动注入
     */
    @Test
    public void test04() {
        //1.加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean01.xml");

        Leader leader = (Leader) context.getBean("leader");
        System.out.println(leader);
    }
}
