package com.foxbill.test;

import com.foxbill.domain.User;
import com.foxbill.service.UserService;
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
    private UserService userService;

    @Test
    public void test01(){
        List<User> users = userService.queryUsers();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test02(){
        userService.dropUser(13);
    }
}
