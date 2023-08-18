package com.foxbill.test;

import com.foxbill.domain.User;
import com.foxbill.mapper.UserMapper;
import com.foxbill.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyBatisTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    public void test01(){
        User user = new User();
        user.setName("云龙");
        user.setAge(38);
        user.setBalance(2000);

        List<User> users = userService.multiSearch(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
