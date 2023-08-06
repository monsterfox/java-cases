package com.foxbill.mybatis;

import com.foxbill.pojo.User;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    SqlSession sqlSession = MyBatisUtil.getSqlSession();

    @Test
    public void queryAll(){
        List<User> list = sqlSession.selectList("test.selectUser");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void search(){
        List<User> list = sqlSession.selectList("test.searchUser","a");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /*新增用户的测试用例*/
    @Test
    public void insert(){
        User user = new User();
        user.setName("aaa");
        user.setAge(12);
        user.setBalance(1000d);
        user.setVersion(1);

        int row = sqlSession.insert("test.insertUser",user);
        sqlSession.commit();//提交事务

        System.out.println(row);
    }

    /*修改用户的测试用例*/
    @Test
    public void update(){
        User user = new User();
        user.setId(1L);
        user.setName("aaa");
        user.setAge(12);
        user.setBalance(1000D);
        user.setVersion(1);

        int row = sqlSession.update("test.updateUser",user);
        sqlSession.commit();//提交事务

        System.out.println(row);
    }

    @Test
    public void deleteUser(){
        int row = sqlSession.delete("test.deleteUser", 18);
        sqlSession.commit();
        System.out.println(row);
        sqlSession.close();
    }

    @Test
    public void searchUser(){
/*        User user = new User();
        user.setUsername("四");*/

        String str = "四";

        List<User> list = sqlSession.selectList("test.searchUser", str);
        for (User u : list) {
            System.out.println(u);
        }
    }
}
