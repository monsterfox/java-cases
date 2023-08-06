# Java-cases
整理了Java相关的学习项目，每个项目重点讲解一个知识点。

# 项目查看顺序

1. spring-leadin:【Spring案例1】Spring框架的引入，了解什么是IoC和DI
2. spring-ioc-xml:【Spring-IoC案例1】
3. spring-ioc-anno:【Spring-IoC案例2】
4. spring-ioc-underlying-principle :【Spring-IoC案例3】
5. spring-aop-leadinto1:【Spring-AOP案例1】 AOP-引入
6. spring-aop-leadinto2:【Spring-AOP案例2】 AOP-自定义代理类
7. spring-aop-leadinto3:【Spring-AOP案例3】 AOP-基于XML实现AOP
8. spring-aop-leadinto4:【Spring-AOP案例4】 AOP-基于注解驱动实现AOP
9. spring-aspectj-before:【Spring-Aspectj案例1】
10. spring-aspectj-afterreturning:【Spring-Aspectj案例2】
11. spring-aspectj-around:【Spring-Aspectj案例3】
12. spring-aspectj-afterthrowing:【Spring-Aspectj案例4】
13. spring-aspectj-after:【Spring-Aspectj案例5】
14. spring-aspectj-pointcut:【Spring-Aspectj案例6】
15. spring-mybatis:【Spring-Mybatis整合案例】
16. spring-trans-sale:【Spring事务案例1】本例要实现购买商品，模拟用户下订单，向订单表添加销售记录，从商品表减少库存。【无事务状态】
17. spring-trans-sale-annotaion:【Spring事务案例2】
18. spring-trans-sale-aspectj:【Spring事务案例3】
19. spring-web01:【Spring-Web案例1】 本例演示了Servlet中如何手动获取Spring容器，并从中获取bean.
20. spring-web02-listener:【Spring-Web案例2】 本例演示了如何通过ContextLoaderListener监听器，自动创建Spring容器，并把容器放入ServletContext作用域，保证在所有的Servlet中都可以拿到同一个Spring容器。
21. springmvc-request-param:【SpringMVC案例1】
22. springmvc-interceptor:【SpringMVC案例2】
23. springmvc-fileupload:【SpringMVC案例3】
24. spring-ssm:【Spring整合SSM案例1】XML
25. spring-ssm-pure-annotation:【Spring整合SSM案例2】纯注解
26. springboot-core-config:【SpringBoot案例1】
27. mybatis-quickstart: MyBatis入门案例
28. mybatis-proxy: MyBatis接口开发（代理开发）
29. mybatis-cache-level1 本例演示了一级缓存（本地缓存） - SqlSession级别
30. mybatis-cache-level2 本例演示了二级缓存（全局缓存） - 跨SQLSession，缓存粒度控制到namespace级别。
31. mybatis-dynamic-sql: MyBatis动态SQL
32. mybatis-association-mapping-1to1 关联映射：1对1
33. mybatis-association-mapping-1-m 关联映射：1对多
34. mybatis-association-mapping-m-n 关联映射：多对多
35. mybatis-annotation 注解开发
36. mybatis-generator MyBatis逆向工程，可以基于数据库表自动帮我们生成实体类，Mapper.java接口和Mapper.xml映射文件。
运行方式一：
    使用maven命令进行自动生成代码，相关设置如下：
    选择Edit Configurations...
    点击加号选择maven
    在Name框填入mybatis-generator然后再Command line 填入mybatis-generator:generate -e
    点击OK
运行方式二：
    运行GeneratorCode.java
    【注意：因为当前是个子模块，可能会出现无法生成代码的情况，其原因是，生成的代码会放在项目的根目录下的相应文件夹中，切记！切记！！！】
37. java-thread
38. java-network
39. interview-basic
    DTD&Schema的演示案例在子目录：xml-dtd和xml-schema中
40. 