package com.foxbill.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

public class MyBatisConfig {

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){

        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        //1.注入连接池对象【必须】
        ssfb.setDataSource(dataSource);
        //2.加载MybatisConfig.xml核心配置文件，
        // 如果核心配置文件中的内容都被抽取了，那么就可以不用加载【可选】
        ClassPathResource resource = new ClassPathResource("mybatis-config.xml");
        ssfb.setConfigLocation(resource);
        //3 配置别名,如果是使用注解配置SQL语句，可以不用配置别名【可选】
        ssfb.setTypeAliasesPackage("com.foxbill.domain");
        //4 加载映射配置文件，如果映射配置文件和mapper接口在同一个包下，并且同名，那么会自动加载【可选】
        //ClassPathResource resource = new ClassPathResource("classpath:StudentMapper.xml");
        //ssfb.setMapperLocations(resource);
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer scannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.foxbill.mapper");
        return mapperScannerConfigurer;
    }
}
