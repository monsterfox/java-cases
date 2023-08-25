package com.foxbill.dao;

import com.foxbill.pojo.User;

import java.util.List;

public interface UserDao {
    void create();
    void add(User user);
    void delete(int id);
    void update(User user);
    List<User> findAllUsers();
    User findUserById(int id);
    int count();
}
