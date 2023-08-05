# Java-cases
整理了Java相关的学习项目，每个项目重点讲解一个知识点。

# 项目查看顺序

1. spring-ioc-xml
2. spring-ioc-anno
3. spring-aop-leadinto1 AOP-引入
4. spring-aop-leadinto2 AOP-自定义代理类
5. spring-aop-leadinto3 AOP-基于XML实现AOP
6. spring-aop-leadinto4 AOP-基于注解驱动实现AOP
7. spring-aspectj-before
8. spring-aspectj-afterreturning
9. spring-aspectj-around
10. spring-aspectj-afterthrowing
11. spring-aspectj-after
12. spring-aspectj-pointcut
13. spring-mybatis
14. spring-trans-sale 本例要实现购买商品，模拟用户下订单，向订单表添加销售记录，从商品表减少库存。【无事务状态】
15. spring-trans-sale-annotaion
16. spring-trans-sale-aspectj
17. spring-web01 本例演示了Servlet中如何手动获取Spring容器，并从中获取bean.
18. spring-web02-listener 本例演示了如何通过ContextLoaderListener监听器，自动创建Spring容器，并把容器放入ServletContext作用域，保证在所有的Servlet中都可以拿到同一个Spring容器。
19. springmvc-request-param
20. springmvc-interceptor
21. springmvc-fileupload
22. spring-ssm
23. spring-ssm-pure-annotation
24. springboot-core-config
25. interview-basic
DTD&Schema的演示案例在子目录：xml-dtd和xml-schema中

26. java-thread
27. java-network
28. mybatis-cache-level1 本例演示了一级缓存（本地缓存） - SqlSession级别
29. mybatis-cache-level2 本例演示了二级缓存（全局缓存） - 跨SQLSession，缓存粒度控制到namespace级别。
30. mybatis-generator MyBatis逆向工程，可以基于数据库表自动帮我们生成实体类，Mapper.java接口和Mapper.xml映射文件。
运行方式一：
    使用maven命令进行自动生成代码，相关设置如下：
    选择Edit Configurations...
    点击加号选择maven
    在Name框填入mybatis-generator然后再Command line 填入mybatis-generator:generate -e
    点击OK
运行方式二：
    运行GeneratorCode.java
    【注意：因为当前是个子模块，可能会出现无法生成代码的情况，其原因是，生成的代码会放在项目的根目录下的相应文件夹中，切记！切记！！！】
31. next