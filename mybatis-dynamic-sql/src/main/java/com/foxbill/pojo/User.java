package com.foxbill.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Double balance;
    private Integer version;
}
