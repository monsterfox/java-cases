package com.foxbill.springbootmybatis.mapper;

import com.foxbill.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insertUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    List<User> selectUsers();
    User getOneUser(int id);

    int minusBalance(User user);
    int addBalance(User user);
}
