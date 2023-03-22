package com.foxbill.mapper;

import com.foxbill.domain.User;

import java.util.List;

public interface UserMapper {
    int insertUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    List<User> selectUsers();
}
