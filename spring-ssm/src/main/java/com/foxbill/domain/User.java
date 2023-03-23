package com.foxbill.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
