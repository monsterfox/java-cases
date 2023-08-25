package com.foxbill.mapper;

import com.foxbill.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /*查询*/
    List<Student> selectStudent();
}