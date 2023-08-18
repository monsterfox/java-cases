package com.foxbill.test;

import com.foxbill.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void test02(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-dao.xml","applicationContext-service.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.dropUser(13);
    }
}
