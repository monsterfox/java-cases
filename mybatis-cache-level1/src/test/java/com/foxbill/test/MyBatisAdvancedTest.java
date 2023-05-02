package com.foxbill.test;

import com.foxbill.mapper.StudentMapper;
import com.foxbill.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisAdvancedTest {

    /**
     * 使用同一个SqlSession对象进行多次查询
     *      运行看结果，可以看出，查询只进行了一次，此为开启一级缓存的情况。
     */
    @Test
    public void test01() throws IOException {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = build.openSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            Student student1 = mapper.selectStudent();
            Student student2 = mapper.selectStudent();

            System.out.println(student1);
            System.out.println(student2);

            sqlSession.close();
    }

    /**
     * 使用不同的SqlSession对象进行查询
     *      运行看结果，可以看出，查询进行了两次，一级缓存没有起作用。
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = build.openSession();
        SqlSession sqlSession2 = build.openSession();

        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);

        Student student1 = mapper1.selectStudent();
        Student student2 = mapper2.selectStudent();

        System.out.println(student1);
        System.out.println(student2);
        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }



}
