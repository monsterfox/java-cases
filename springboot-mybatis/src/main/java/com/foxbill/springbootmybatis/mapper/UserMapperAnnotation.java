package com.foxbill.springbootmybatis.mapper;

import com.foxbill.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapperAnnotation {
    @Insert("insert into user values(null,#{name},#{age},#{balance})")
    int insertUser(User user);
    @Delete("delete from user where id= #{id}")
    int deleteUser(int id);
    @Update("update user set name = #{name},age = #{age},balance = #{balance} where id = #{id}")
    int updateUser(User user);
    @Select("select * from user")
    List<User> selectUsers();
    @Select("select * from user where id = #{id}")
    User getOneUser(int id);

    @Update("update user set balance = balance - #{balance} where id = #{id}")
    int minusBalance(User user);
    @Update("update user set balance = balance + #{balance} where id = #{id}")
    int addBalance(User user);
}
