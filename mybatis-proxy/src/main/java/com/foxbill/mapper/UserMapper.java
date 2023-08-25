package com.foxbill.mapper;

import com.foxbill.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    public List<User> selectUser();
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(int id);
    public List<User> searchUser1(String keywords);
    public List<User> searchUser2(User user);
    public User selectUserById(int id);
}
