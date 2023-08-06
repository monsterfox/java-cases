package com.foxbill.test;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.util.MyBatisUtil;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {

    SqlSession sqlSession = MyBatisUtil.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void test01(){
        List<User> list = userMapper.selectUser();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test02(){
        User user = userMapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void test03(){
        String keywords = "云";

        List<User> users = userMapper.searchUser1(keywords);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test04(){
        User u = new User();
        u.setName("云");

        List<User> users = userMapper.searchUser2(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void cacheTest(){
        //SqlSession sqlSession = MyBatisUtil.getSqlSession();

        //第一次查询
        User user1 = userMapper.selectUserById(1);
        System.out.println(user1);

        //第二次查询
        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);
    }

    @Test
    public void cacheTest2(){
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        //第一次查询
        User user1 = mapper1.selectUserById(1);
        System.out.println(user1);

        //第二次查询
        User user2 = mapper2.selectUserById(1);
        System.out.println(user2);
    }
}
