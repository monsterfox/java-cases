package com.foxbill.service;

import com.foxbill.domain.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);
    boolean dropStudent(int id);
    boolean modifyStudent(Student student);
    List<Student> queryStudents();

}
