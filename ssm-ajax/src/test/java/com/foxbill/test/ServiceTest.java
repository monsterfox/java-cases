package com.foxbill.test;

import com.foxbill.domain.Student;
import com.foxbill.mapper.StudentMapper;
import com.foxbill.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class ServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test01(){
        PageInfo<Student> pageInfo = studentService.findStudentsByPage(2);
        System.out.println(pageInfo);
        pageInfo.getList().forEach(student -> System.out.println(student));
    }

}
