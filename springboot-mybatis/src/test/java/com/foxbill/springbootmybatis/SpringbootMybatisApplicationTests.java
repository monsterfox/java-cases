package com.foxbill.springbootmybatis;

import com.foxbill.springbootmybatis.mapper.UserMapper;
import com.foxbill.springbootmybatis.mapper.UserMapperAnnotation;
import com.foxbill.springbootmybatis.pojo.User;
import com.foxbill.springbootmybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperAnnotation userMapperAnnotation;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectUsers();
        users.forEach((user)->{
            System.out.println(user);
        });
    }

    @Test
    void testuserMapperAnnotation(){
        List<User> users = userMapperAnnotation.selectUsers();
        users.forEach((user)->{
            System.out.println(user);
        });
    }

    @Test
    void testTransactional(){
        userService.transfer(1,4,3);
    }

}
