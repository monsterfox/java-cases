package com.foxbill.test;

import com.foxbill.config.JdbcConfig;
import com.foxbill.config.SpringConfig;
import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class AnnotationTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentService studentService = context.getBean("studentService", StudentService.class);
        List<Student> list = studentService.queryStudents();
        for (Student student : list) {
            System.out.println(student);
        }


    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

    }
}
