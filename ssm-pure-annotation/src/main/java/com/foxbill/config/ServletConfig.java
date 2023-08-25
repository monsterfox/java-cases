package com.foxbill.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //加载SpringConfig配置类,产生spring容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    //加载SpringMvcConfig配置类,产生springmvc容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    //设置由springmvc控制器处理的请求映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}