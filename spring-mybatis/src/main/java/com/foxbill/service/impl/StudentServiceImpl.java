package com.foxbill.service.impl;

import com.foxbill.dao.StudentDao;
import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //定义Dao的引用类型的属性
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int modifyStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int removeStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.selectAllStudents();
    }
}
