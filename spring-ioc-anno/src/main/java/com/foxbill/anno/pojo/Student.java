package com.foxbill.anno.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 */

//@Component(value = "myStudent")
@Component("myStudent")
public class Student {
//    @Value(value = "李四")
    @Value("${myName}")
    private String name;

//    @Value(value = "21")
    @Value("${myAge}")
    private int age;


    /**  引用类型注入-注解  */

/*    @Autowired //默认byType
    @Qualifier("mySchool") //通过@Autowired 注解 要使用byName方式赋值，需要配合@Qualifier 使用*/

    @Resource //先按照byName赋值，如果失败，再使用byType。  默认是byName
//    @Resource(name = "mySchool")  //只使用byName方式赋值，即名称必须相同
    private School school;


    public Student() {
        System.out.println("Student 无参构造");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
