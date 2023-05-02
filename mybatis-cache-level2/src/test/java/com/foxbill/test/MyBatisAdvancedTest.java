package com.foxbill.test;

import com.foxbill.mapper.StudentMapper;
import com.foxbill.mapper.UserMapper;
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
     *
     *      如果演示失败：     *
     *      注意：测试二级缓存需要commit提交，如果不提交是不会保存到二级缓存的
     *
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
        sqlSession1.commit();//测试二级缓存需要commit提交，如果不提交是不会保存到二级缓存的
        Student student2 = mapper2.selectStudent();

        System.out.println(student1);
        System.out.println(student2);

        sqlSession2.commit();

        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }

    /**
     * 测试DML操作将二级缓存清空的情况
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = build.openSession();
        SqlSession sqlSession2 = build.openSession();

        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);

        /*
            使用两个不同的SqlSession对象在同一个命名空间内操作，
            其中一个更改了数据库的数据，观察另一个是否使用缓存数据
        */
        Student student1 = mapper1.selectStudent();

        mapper2.updateStudent();
        sqlSession2.commit();

        Student student2 = mapper2.selectStudent();

        System.out.println(student1);
        System.out.println(student2);
        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }

    /**
     * 测试开启二级缓存后，出现的脏读情况
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = build.openSession();
        SqlSession sqlSession2 = build.openSession();
        /*
            使用两个不同的SqlSession对象操作，一级缓存失效
         */
        StudentMapper studentmapper = sqlSession1.getMapper(StudentMapper.class);
        UserMapper usermapper = sqlSession2.getMapper(UserMapper.class);
        /*
            使用两个不同的sqlSession对象在同一个命名空间内操作，
            其中一个更改了数据库的数据，观察另一个是否使用缓存数据
         */
        Student student1 = studentmapper.selectStudent();
        usermapper.updateStudent();

        /*
            注意，两个SqlSession对象不同，因此需要先提交SqlSession2的操作
         */
        sqlSession2.commit();

        Student student2 = studentmapper.selectStudent();

        System.out.println(student1);
        System.out.println(student2);
        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }



}
