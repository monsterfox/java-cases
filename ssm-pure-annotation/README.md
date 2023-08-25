## XML方式

- 配置文件格式：xml
- 属性文件导入 <context:property-placeholder location="classpath:jdbc.properties" />
- 包扫描自定义bean： <context:component-scan base-package="com.foxbill.service" />
- 第三方bean: < bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" >
- 导入其他配置文件（xml） < import resource="spring-basic.xml" />
- 开启自动代理-AOP ：<aop:aspectj-autoproxy proxy-target-class="true"  />
- 开启事务注解驱动：<tx:annotation-driven transaction-manager="transactionManager" />
- 开启MVC注解驱动：< mvc:annotation-driven/>

## Annotation方式

  - 配置文件格式：java类    @Configuration
  - 属性文件导入   @PropertySource(value = "classpath:jdbc.properties")
  - 包扫描自定义bean： @ComponentScan(value = {"com.foxbill.service","com.foxbill.controller"})
      - @Component
      - @Repository
      - @Service
      - @Controller
  - 第三方bean：@Bean   @Value
  - 导入其他配置文件（类） @Import({JdbcConfig.class,MyBatisConfig.class})
  - 开启自动代理-AOP ：@EnableAspectJAutoProxy
  - 开启事务注解驱动：@EnableTransactionManagement
  - 开启MVC注解驱动：@EnableWebMvc 



Spring启用Log4j2日志框架:
https://blog.csdn.net/weixin_45832694/article/details/127621655