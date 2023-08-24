package com.foxbill.service;

import com.foxbill.pojo.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    int modifyStudent(Student student);
    int removeStudent(int id);

    Student findStudentById(int id);
    List<Student> findAllStudents();
}
