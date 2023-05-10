package com.foxbill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan("com.foxbill")
@ComponentScan(
    value = "com.foxbill",              //设置基础扫描路径
    excludeFilters =                    //设置过滤规则，当前为排除过滤
    @ComponentScan.Filter(              //设置过滤器
        type = FilterType.ANNOTATION,   //设置过滤方式为按照注解进行过滤
        classes = Service.class         //设置具体的过滤项，过滤所有@Repository修饰的bean
    )
)
public class SpringConfig {
}
