package com.foxbill.mapper;

import com.foxbill.domain.Student;

import java.util.List;

public interface StudentMapper {
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int id);

    Student selectStudentById(int id);
    List<Student> selectAllStudents();

}
