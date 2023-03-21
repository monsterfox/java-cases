package com.foxbill.mapper;

import com.foxbill.domain.Student;

import java.util.List;

public interface StudentMapper {
    int insertStudent(Student student);
    int deleteStudent(int id);
    int updateStudent(Student student);
    List<Student> selectStudents();
}
