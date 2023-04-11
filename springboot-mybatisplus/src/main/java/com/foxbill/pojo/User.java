package com.foxbill.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private double balance;

    public User(Integer id, double balance) {
        this.id = id;
        this.balance = balance;
    }
}
