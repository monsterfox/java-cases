package com.foxbill.anno.test;

import com.foxbill.anno.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ctx.getBean("myStudent");

        System.out.println(myStudent);
    }
}
