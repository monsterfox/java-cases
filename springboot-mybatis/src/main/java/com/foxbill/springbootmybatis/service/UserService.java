package com.foxbill.springbootmybatis.service;

import com.foxbill.springbootmybatis.pojo.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean dropUser(int id);
    boolean modifyUser(User user);
    List<User> queryUsers();
    User findUser(int id);
    boolean transfer(int fromId, int toId, double balance);
}
