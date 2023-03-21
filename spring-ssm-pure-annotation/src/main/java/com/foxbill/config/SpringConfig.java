package com.foxbill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@ComponentScan(value = {"com.foxbill.service","com.foxbill.controller"})
//@ComponentScan(value = {"com.foxbill.config","com.foxbill.service","com.foxbill.controller"})  //若使用@ComponentScan，则JdbcConfig需要加@Configuration
@Import({JdbcConfig.class,MyBatisConfig.class})   //若使用@Import导入，则JdbcConfig不需要加@Configuration
public class SpringConfig {

/*    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String  username;
    @Value("${jdbc.password}")
    private String  password;

    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }*/

}
