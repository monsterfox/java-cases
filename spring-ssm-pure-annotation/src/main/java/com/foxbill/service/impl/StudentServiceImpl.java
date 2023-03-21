package com.foxbill.service.impl;

import com.foxbill.domain.Student;
import com.foxbill.mapper.StudentMapper;
import com.foxbill.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean addStudent(Student student) {
        return (studentMapper.insertStudent(student)!=0)?true:false;
    }

    @Override
    public boolean dropStudent(int id) {
        return (studentMapper.deleteStudent(id)!=0)?true:false;
    }

    @Override
    public boolean modifyStudent(Student student) {
        return (studentMapper.updateStudent(student)!=0)?true:false;
    }

    @Override
    public List<Student> queryStudents() {
        return studentMapper.selectStudents();
    }
}
