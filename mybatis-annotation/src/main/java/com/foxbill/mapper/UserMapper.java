package com.foxbill.mapper;

import com.foxbill.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> selectUser();

    @Insert("insert into user values(null,#{name},#{age},#{balance},#{version})")
    public int insertUser(User user);

    @Update("        update user set name = #{name},age = #{age}, balance = #{balance},version = #{version} where id = #{id}")
    public int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public int deleteUser(int id);

    @Select("select * from user where name like '%${_parameter}%'")
    public List<User> searchUser1(String keywords);

    @Select("select * from user where name like '%${name}%'")
    public List<User> searchUser2(User user);
    @Select("select * from user where id = #{id}")
    public User selectUserById(int id);
}
