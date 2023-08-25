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
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取SqlSessionFactory - 工厂对象
        builder = new SqlSessionFactoryBuilder();
        System.out.println(builder);
        sqlSessionFactory = builder.build(inputStream);
        System.out.println(sqlSessionFactory);
    }

    //获取SqlSession
    public static SqlSession getSqlSession(){
        //获取SqlSession - 连接对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    //关闭SqlSession
    public static void closeSqlSession(SqlSession session){
        if (session != null) {
            session.close();
        }
    }

}