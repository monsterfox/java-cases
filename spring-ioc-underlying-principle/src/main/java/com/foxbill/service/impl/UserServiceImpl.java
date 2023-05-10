package com.foxbill.service.impl;

import com.foxbill.dao.BookDao;
import com.foxbill.dao.UserDao;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("user service running...");
        userDao.save();
        bookDao.save();
    }
}
