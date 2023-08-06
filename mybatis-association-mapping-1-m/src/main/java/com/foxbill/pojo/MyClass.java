package com.foxbill.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MyClass {
    Integer id;
    String className;
    List<Student> student;
}