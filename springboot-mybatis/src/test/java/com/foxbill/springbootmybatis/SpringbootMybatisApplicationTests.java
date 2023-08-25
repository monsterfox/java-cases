package com.foxbill.springbootmybatis;

import com.foxbill.springbootmybatis.mapper.UserMapper;
import com.foxbill.springbootmybatis.mapper.UserMapperAnnotation;
import com.foxbill.springbootmybatis.pojo.User;
import com.foxbill.springbootmybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * 测试分页插件的使用
     */
    @Test
    void testPagination(){
        PageHelper.startPage(2,1);
        List<User> list = userService.queryUsers();
        PageInfo<User> pageInfo = new PageInfo<>(list, 3);
        System.out.println(pageInfo);
        list.forEach(user -> {
            System.out.println(user);
        });
    }

}
