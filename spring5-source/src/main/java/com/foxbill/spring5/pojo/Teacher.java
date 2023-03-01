package com.foxbill.spring5.pojo;

public class Teacher {
    private String name;
    private int age;
    private School school;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Teacher(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
