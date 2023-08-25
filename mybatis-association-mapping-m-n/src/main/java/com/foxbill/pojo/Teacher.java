package com.foxbill.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    Integer id;
    String courseName;
    String name;
    List<Student> students;
}