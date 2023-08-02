package com.foxbill.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * 代替spring的配置文件
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@ComponentScan(value = {"com.foxbill.service"})
/*
    导入其他配置类-方式二：
    若使用@ComponentScan，则JdbcConfig需要加@Configuration
 */
//@ComponentScan(value = {"com.foxbill.config","com.foxbill.service","com.foxbill.controller"})

/*
    导入其他配置类-方式一：
    若使用@Import导入，则JdbcConfig不需要加@Configuration
 */
@Import({JdbcConfig.class,MyBatisConfig.class})
@EnableAspectJAutoProxy  //AOP Aspectj注解驱动 <aop:aspectj-autoproxy proxy-target-class="true"  />
@EnableTransactionManagement  //事务注解驱动 <tx:annotation-driven transaction-manager="transactionManager" />

//@EnableWebMvc  // 开启mvc注解驱动 <mvc:annotation-driven/>
public class SpringConfig {

    /*事务管理器*/
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
