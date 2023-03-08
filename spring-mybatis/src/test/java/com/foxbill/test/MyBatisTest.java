package com.foxbill.test;

import com.foxbill.dao.StudentDao;
import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyBatisTest {


    @Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象的名称：" + name +"===对象类型：" + ctx.getBean(name));
        }
    }

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

    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
        System.out.println(studentDao);
        Student student = new Student();
        student.setName("李四");
        student.setAge(30);

//        studentDao.insertStudent(student);
    }
}
