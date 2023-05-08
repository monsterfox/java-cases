package com.foxbill.test;

import com.foxbill.mapper.StudentMapper;
import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.Student;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisAdvancedTest {

    /**
     * Case1:使用同一个SqlSession对象进行多次查询
     *      运行看结果，可以看出，查询只进行了一次，此为开启一级缓存的情况。
     */
    @Test
    public void test01() {
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            Student student1 = mapper.selectStudent();
            Student student2 = mapper.selectStudent();

            System.out.println(student1);
            System.out.println(student2);

            sqlSession.close();
    }

    /**
     * Case2-3:使用不同的SqlSession对象进行查询（测试时,记得把二级缓存关闭）：
     *      运行看结果，可以看出:
     *          Case2:如果关闭二级缓存，SQL查询进行两次，一级缓存没有起作用。  <setting name="cacheEnabled" value="false"/>
     *          Case3:如果开启二级缓存，SQL查询进行一次，二级缓存起作用。  <setting name="cacheEnabled" value="true"/>
     *
     *      如果演示失败：
     *          注意：测试二级缓存需要commit提交，如果不提交是不会保存到二级缓存的
     *
     * @throws IOException
     */
    @Test
    public void test02(){
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();

        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);

        Student student1 = mapper1.selectStudent();
        sqlSession1.commit();//测试二级缓存需要commit提交，如果不提交是不会保存到二级缓存的
        Student student2 = mapper2.selectStudent();
        sqlSession2.commit();

        System.out.println(student1);
        System.out.println(student2);


        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }

    /**
     * Case4:测试DML操作将二级缓存清空的情况
     * @throws IOException
     */
    @Test
    public void test03(){
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();

        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);

        /*
            使用两个不同的SqlSession对象在同一个命名空间内操作，
            其中一个更改了数据库的数据，观察另一个是否使用缓存数据
        */
        Student student1 = mapper1.selectStudent();
        sqlSession1.commit();//测试二级缓存需要commit提交，如果不提交是不会保存到二级缓存的
        mapper2.updateStudent();
        sqlSession2.commit();//提交事务，使更新生效，同时清空二级缓存

        Student student2 = mapper2.selectStudent();

        System.out.println(student1);
        System.out.println(student2);
        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }

    /**
     * Case5:测试开启二级缓存后，在不规范开发时，可能出现的脏读情况
     * @throws IOException
     */
    @Test
    public void test04(){
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        /*
            使用两个不同的SqlSession对象操作，一级缓存失效
         */
        StudentMapper studentmapper = sqlSession1.getMapper(StudentMapper.class);
        UserMapper usermapper = sqlSession2.getMapper(UserMapper.class); //注意，不管用sqlSession1还是sqlSession2获取usermapper,都会出现脏读现象
        /*
            使用两个不同的sqlSession对象在同一个命名空间内操作，
            其中一个更改了数据库的数据，观察另一个是否使用缓存数据
         */
        Student student1 = studentmapper.selectStudent();
        sqlSession1.commit();
        usermapper.updateStudent();
        sqlSession2.commit();
        /*
            注意，两个SqlSession对象不同，因此需要先提交SqlSession2的操作
         */

        Student student2 = studentmapper.selectStudent();

        System.out.println(student1);
        System.out.println(student2);
        //关闭事务
        sqlSession1.close();
        sqlSession2.close();
    }



}
