package com.foxbill.pojo;

import lombok.Data;

@Data
public class Student {
    Integer id;
    String name;
    Card card; //每个学生都有一个学生卡 card
    //Integer cid;
}