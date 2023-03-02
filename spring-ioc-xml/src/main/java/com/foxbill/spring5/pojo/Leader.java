package com.foxbill.spring5.pojo;

public class Leader {
    private String name;
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
