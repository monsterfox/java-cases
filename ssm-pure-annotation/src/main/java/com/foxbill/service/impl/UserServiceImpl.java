package com.foxbill.service.impl;

import com.foxbill.domain.User;
import com.foxbill.mapper.UserMapper;
import com.foxbill.service.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        logger.info("我是一条日志消息");
        return userMapper.selectUsers();
    }

    @Override
    public User findUser(int id) {
        return userMapper.getOneUser(id);
    }

    @Transactional
    @Override
    public boolean transfer(int fromId, int toId, double balance) {
        int r1 = userMapper.minusBalance(new User(fromId,balance));
        //int a = 10 / 0; //测试事务
        int r2 = userMapper.addBalance(new User(toId,balance));
        return (r1 > 0 && r2 > 0)?true:false;
    }
}
