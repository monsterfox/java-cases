package com.foxbill.coreconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//1.使用@PropertySource加载自定义配置文件
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "test")

//2.使用@ImportResource加载XML配置文件
//@ImportResource("classpath:beans.xml") //加载自定义xml配置文件

//3.使用@Configuration编写自定义配置类
public class SpringbootCoreConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCoreConfigApplication.class, args);
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpringbootCoreConfigApplication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
