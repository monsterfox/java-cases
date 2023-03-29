package com.foxbill.coreconfig.config;

import com.foxbill.coreconfig.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyService myService(){
        return new MyService();
    }
}
