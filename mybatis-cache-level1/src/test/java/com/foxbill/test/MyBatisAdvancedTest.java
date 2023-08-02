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

            //第一次查询 id为1的学生信息
            StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);
            Student student1 = mapper1.selectStudent();
            System.out.println(student1);

            //第二次查询 id为1的学生信息
            StudentMapper mapper2 = sqlSession.getMapper(StudentMapper.class);
            Student student2 = mapper2.selectStudent();
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
        Student student1 = mapper1.selectStudent();
        System.out.println(student1);

        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        Student student2 = mapper2.selectStudent();
        System.out.println(student2);

        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }

    /**
     * 使用SqlSession对象的clearCache()方法，可以清空缓存
     *      运行看结果，可以看出，因第一次查询后清空了缓存，所以第二次查询相同数据时，又重新从数据库中查询了数据。
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        //第一次查询 id为1的学生信息
        StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);
        Student student1 = mapper1.selectStudent();
        System.out.println(student1);

        //清空缓存
        sqlSession.clearCache();

        //第二次查询 id为1的学生信息
        StudentMapper mapper2 = sqlSession.getMapper(StudentMapper.class);
        Student student2 = mapper2.selectStudent();
        System.out.println(student2);

        sqlSession.close();
    }

    /**
     * 当SqlSession中执行任何一个DML操作，即增加、删除或更改操作时，都将清空此SqlSession的一级缓存
     *
     *      运行看结果，可以看出，因第一次查询后清空了缓存，所以第二次查询相同数据时，又重新从数据库中查询了数据。
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        //第一次查询 id为1的学生信息
        StudentMapper mapper1 = sqlSession.getMapper(StudentMapper.class);
        Student student1 = mapper1.selectStudent();
        System.out.println(student1);

        //执行DML操作后，会清空缓存
        int row = mapper1.updateStudent();
        System.out.println("执行了DML操作");

        //第二次查询 id为1的学生信息
        StudentMapper mapper2 = sqlSession.getMapper(StudentMapper.class);
        Student student2 = mapper2.selectStudent();
        System.out.println(student2);

        sqlSession.close();
    }


}
