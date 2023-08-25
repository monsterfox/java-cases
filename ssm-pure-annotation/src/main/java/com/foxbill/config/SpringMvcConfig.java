package com.foxbill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
//声明当前类为Spring配置类
@Configuration
//SpringMVC注解扫描
@ComponentScan("com.foxbill.controller")
//开启SpringMVC多项辅助功能，如Json数据进行自动类型转换等
@EnableWebMvc
public class SpringMvcConfig {
}