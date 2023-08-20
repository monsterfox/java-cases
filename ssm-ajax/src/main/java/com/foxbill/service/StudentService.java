package com.foxbill.service;

import com.foxbill.domain.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    int modifyStudent(Student student);
    int removeStudent(int id);

    Student findStudentById(int id);
    List<Student> findAllStudents();
    PageInfo<Student> findStudentsByPage(int papeNum);
}
