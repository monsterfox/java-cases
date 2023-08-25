package com.foxbill.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    Integer id;
    String name;
    List<Teacher> teachers;
}