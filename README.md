# Java-cases
整理了Java相关的学习项目，每个项目重点讲解一个知识点。

# 项目查看顺序

1. mybatis-quickstart: MyBatis入门案例
2. mybatis-proxy: MyBatis接口开发（代理开发）
3. mybatis-cache-level1 本例演示了一级缓存（本地缓存） - SqlSession级别
4. mybatis-cache-level2 本例演示了二级缓存（全局缓存） - 跨SQLSession，缓存粒度控制到namespace级别。
5. mybatis-dynamic-sql: MyBatis动态SQL
6. mybatis-association-mapping-1to1 关联映射：1对1
7. mybatis-association-mapping-1-m 关联映射：1对多
8. mybatis-association-mapping-m-n 关联映射：多对多
9. mybatis-annotation 注解开发
10. mybatis-generator MyBatis逆向工程，可以基于数据库表自动帮我们生成实体类，Mapper.java接口和Mapper.xml映射文件。
运行方式一：
    使用maven命令进行自动生成代码，相关设置如下：
    选择Edit Configurations...
    点击加号选择maven
    在Name框填入mybatis-generator然后再Command line 填入mybatis-generator:generate -e
    点击OK
运行方式二：
    运行GeneratorCode.java
    【注意：因为当前是个子模块，可能会出现无法生成代码的情况，其原因是，生成的代码会放在项目的根目录下的相应文件夹中，切记！切记！！！】
11. spring-leadin:【Spring案例1】Spring框架的引入，了解什么是IoC和DI
12. spring-ioc-xml:【Spring-IoC案例1】
13. spring-ioc-anno:【Spring-IoC案例2】
14. spring-ioc-underlying-principle :【Spring-IoC案例3】
15. spring-aop-leadinto1:【Spring-AOP案例1】 AOP-引入
16. spring-aop-leadinto2:【Spring-AOP案例2】 AOP-自定义代理类
17. spring-aspectj-quickstart-xml:【Spring-AOP案例3】 AOP-基于XML实现AOP
     Spring帮我们生成代理对象，进行功能的增强。
18. spring-aspectj-quickstart-annotation:【Spring-AOP案例4】 AOP-基于注解驱动实现AOP
     同上
19. spring-aspectj-before:【Spring-Aspectj案例1】
20. spring-aspectj-afterreturning:【Spring-Aspectj案例2】
21. spring-aspectj-around:【Spring-Aspectj案例3】
22. spring-aspectj-afterthrowing:【Spring-Aspectj案例4】
23. spring-aspectj-after:【Spring-Aspectj案例5】
24. spring-aspectj-pointcut:【Spring-Aspectj案例6】
25. spring-jdbcTemplate:【Spring-jdbcTemplate】jdbcTemplate
26. spring-mybatis:【Spring-Mybatis整合案例】
27. spring-trans-sale:【Spring事务案例1】本例要实现购买商品，模拟用户下订单，向订单表添加销售记录，从商品表减少库存。【无事务状态】
28. spring-trans-sale-annotaion:【Spring事务案例2】
    事务是通过切面进行增强的功能，一般事务要加在业务层service，因此我们获取到的service对象，实际上个代理对象。
    即
29. spring-trans-sale-aspectj:【Spring事务案例3】
30. spring-trans-sale-propagation:【Spring事务案例4】事务的传播特性 - 测试包里有Excel表格，用于演示各种组合场景
31. spring-trans-isolation-xx:【Spring事务案例x】事务的隔离级别
32. spring-web01:【Spring-Web案例1】 本例演示了Servlet中如何手动获取Spring容器，并从中获取bean.
33. spring-web02-listener:【Spring-Web案例2】 本例演示了如何通过ContextLoaderListener监听器，自动创建Spring容器，并把容器放入ServletContext作用域，保证在所有的Servlet中都可以拿到同一个Spring容器。
34. springmvc-request-param:【SpringMVC案例1】
35. springmvc-interceptor:【SpringMVC案例2】
36. springmvc-fileupload:【SpringMVC案例3】
37. spring-ssm:【Spring整合SSM案例1】XML
38. spring-ssm-pure-annotation:【Spring整合SSM案例2】纯注解
39. springboot-core-config:【SpringBoot案例1】
40. java-thread
41. java-network
42. interview-basic
    DTD&Schema的演示案例在子目录：xml-dtd和xml-schema中
43. 