package com.foxbill.test;

import com.foxbill.config.JdbcConfig;
import com.foxbill.config.SpringConfig;
import com.foxbill.domain.User;
import com.foxbill.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class AnnotationTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        List<User> list = userService.queryUsers();
        for (User user : list) {
            System.out.println(user);
        }


    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

    }
}
