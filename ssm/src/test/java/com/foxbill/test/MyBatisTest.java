package com.foxbill.test;

import com.foxbill.domain.User;
import com.foxbill.mapper.UserMapper;
import com.foxbill.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
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

    @Test
    public void pageSearch(){
        PageHelper.startPage(2,1);
        List<User> users = userService.queryUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users, 3);
        System.out.println(pageInfo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
