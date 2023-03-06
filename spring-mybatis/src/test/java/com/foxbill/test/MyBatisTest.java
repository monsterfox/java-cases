package com.foxbill.test;

import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyBatisTest {

    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) ctx.getBean("studentService");
        List<Student> allStudent = studentService.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
}
