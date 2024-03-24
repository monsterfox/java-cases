package com.foxbill.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块 - 类加载的时候，只执行一次
    static {
        //获取SqlSession
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        builder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory - 工厂对象
        sqlSessionFactory = builder.build(inputStream);
    }


    //获取SqlSession
    public static SqlSession getSqlSession(){
        //获取SqlSession - 连接对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //开启事务自动提交
        return sqlSession;
    }

    //关闭SqlSession
    public static void closeSqlSession(SqlSession session){
        if (session != null) {
            session.close();
        }
    }

    public static SqlSessionFactoryBuilder getBuilder(){
        return builder;
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
