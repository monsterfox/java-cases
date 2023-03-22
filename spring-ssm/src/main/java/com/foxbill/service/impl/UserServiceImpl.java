package com.foxbill.service.impl;

import com.foxbill.domain.User;
import com.foxbill.mapper.UserMapper;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return (userMapper.insertUser(user)!=0)?true:false;
    }

    @Override
    public boolean dropUser(int id) {
        return (userMapper.deleteUser(id)!=0)?true:false;
    }

    @Override
    public boolean modifyUser(User user) {
        return (userMapper.updateUser(user)!=0)?true:false;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.selectUsers();
    }
}
