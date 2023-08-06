package com.foxbill;

import com.foxbill.dao.UserDao;
import com.foxbill.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestJdbcTemplate {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");

        List<User> list = userDao.findAllUsers();
        list.forEach(System.out::println);

    }
}
