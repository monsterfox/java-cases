package com.foxbill.service.impl;

import com.foxbill.mapper.StudentMapper;
import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int modifyStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int removeStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public PageInfo<Student> findStudentsByPage(int pageNum) {
        PageHelper.startPage(pageNum,2);
        List<Student> list = studentMapper.selectAllStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(list, 3);
        return pageInfo;
    }


}
