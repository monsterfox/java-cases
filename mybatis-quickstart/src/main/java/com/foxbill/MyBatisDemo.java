package com.foxbill;

import com.foxbill.pojo.User;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<User> list = sqlSession.selectList("test.selectUser");
        System.out.println(list.size());

    }
}