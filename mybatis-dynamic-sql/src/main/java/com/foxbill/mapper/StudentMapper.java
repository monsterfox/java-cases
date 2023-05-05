package com.foxbill.mapper;

import com.foxbill.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentMapper {
    List<Student> queryStudent1(Student student);
    List<Student> queryStudent2(Student student);
    List<Student> queryStudent3(Student student);
    List<Student> queryStudent4(Student student);
    int updateStudent1(Student student);
    int updateStudent2(Student student);
    List<Student> queryStudentForEach(@Param("idList") List idList);
    List<Student> queryStudentBind(String key);
}
