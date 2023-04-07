package com.foxbill.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private double balance;

    public User(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
}
