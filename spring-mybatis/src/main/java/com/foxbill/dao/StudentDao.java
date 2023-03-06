package com.foxbill.dao;

import com.foxbill.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int id);

    Student selectStudentById(int id);
    List<Student> selectAllStudents();
}
