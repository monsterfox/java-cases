package com.foxbill.test;

import com.foxbill.mapper.StudentMapper;
import com.foxbill.pojo.Student;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AssociateTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectStudent();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}