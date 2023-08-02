package com.foxbill.coreconfig;

import com.foxbill.coreconfig.pojo.MyProperties;
import com.foxbill.coreconfig.pojo.Person;
import com.foxbill.coreconfig.pojo.Student;
import com.foxbill.coreconfig.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootCoreConfigApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private Student student;

    @Autowired
    private MyProperties myProperties;
    @Autowired
    private SpringbootCoreConfigApplication springbootCoreConfigApplication;

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MyService myService;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testValueAnnotation(){
        System.out.println(student);
    }

    @Test
    void testPropertySource(){
//        System.out.println(myProperties);
        System.out.println(springbootCoreConfigApplication);
    }

    @Test
    void testImportResource(){
        System.out.println(applicationContext.containsBean("myService"));
        System.out.println(myService);
    }



}
