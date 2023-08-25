package com.foxbill.test;

import com.foxbill.mapper.StudentMapper;
import com.foxbill.pojo.Student;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisAdvancedTest {

    SqlSession sqlSession = MyBatisUtil.getSqlSesssion();
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

    @Test
    public void test00() throws IOException {
        Student student = new Student();
        student.setName("马云");
        //student.setAge(50);

        List<Student> list = mapper.queryStudent0(student);
        list.forEach(System.out::println);
    }

    @Test
    public void test01() {
        Student student = new Student();
        student.setName("张三"); //如果在映射文件中只用if,在没有设置name时，拼接的sql会有错
        student.setAge(42);

        List<Student> list = mapper.queryStudent1(student);
        list.forEach(System.out::println);
    }
    @Test
    public void test02() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(42);

        List<Student> list = mapper.queryStudent2(student);
        list.forEach(System.out::println);
    }
    @Test
    public void test03() {
        Student student = new Student();
        student.setId(1);
//        student.setName("张三");
        student.setAge(12);

        int row = mapper.updateStudent1(student);
        sqlSession.commit();
        System.out.println(row);
    }
    @Test
    public void test04(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(12);

        int row = mapper.updateStudent2(student);
        sqlSession.commit();
        System.out.println(row);
    }

    @Test
    public void test05() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(12);

        List<Student> list = mapper.queryStudent3(student);
        list.forEach(System.out::println);
    }

    @Test
    public void test06() {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(12);

        List<Student> list = mapper.queryStudent4(student);
        list.forEach(System.out::println);
    }

    @Test
    public void test07() {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(12);

        List<Student> list = mapper.queryStudent4(student);
        list.forEach(System.out::println);
    }
    @Test
    public void test08() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);

        List<Student> list = mapper.queryStudentForEach(idList);
        list.forEach(System.out::println);
    }

    @Test
    public void test09() {
        Student student = new Student();
        student.setName("三");

        List<Student> list = mapper.queryStudentBind(student);
        list.forEach(System.out::println);
    }

    @Test
    public void test10() {
        List<Student> list = mapper.queryStudentBind2("三");
        list.forEach(System.out::println);
    }
}
