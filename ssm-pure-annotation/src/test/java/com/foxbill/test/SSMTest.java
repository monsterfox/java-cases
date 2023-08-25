package com.foxbill.test;

import com.foxbill.config.SpringConfig;
import com.foxbill.mapper.StudentMapper;
import com.foxbill.pojo.Student;
import com.foxbill.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SSMTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentService studentService = (StudentService) context.getBean("studentServiceImpl");
        List<Student> students = studentMapper.selectAllStudents();
        students.forEach(student -> {
            System.out.println(student);
        });
    }
}
