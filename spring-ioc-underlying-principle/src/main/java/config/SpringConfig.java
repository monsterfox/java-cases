package config;

import config.postprocessor.MyBeanFactoryPostProcessor;
import config.postprocessor.MyBeanPostProcessor;
import config.registrar.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
/*
    bean过滤器
*/

@ComponentScan("com.foxbill")
/*@ComponentScan(
    value = "com.foxbill",              //设置基础扫描路径
    excludeFilters =                    //设置过滤规则，当前为排除过滤
    @ComponentScan.Filter(              //设置过滤器
        type = FilterType.ANNOTATION,   //设置过滤方式为按照注解进行过滤
        classes = Service.class         //设置具体的过滤项，过滤所有@Repository修饰的bean
    )
)*/

/*@ComponentScan(
    value = "com.foxbill",              //设置基础扫描路径
    excludeFilters =                    //设置过滤规则，当前为排除过滤
    @ComponentScan.Filter(              //设置过滤器
        type = FilterType.CUSTOM,       //设置过滤方式为按照注解进行过滤
        classes = MyTypeFilter.class    //设置具体的过滤项，过滤所有@Repository修饰的bean
    )
)*/

/*
    bean导入器
*/
//@Import(MyImportSelector.class)

/*
    bean注册器 - 模拟@ComponentScan
 */
//@Import(MyImportBeanDefinitionRegistrar.class)

/*
    BeanFactoryPostProcessor  bean工厂创建后的初始化工作
 */
@Import({MyBeanFactoryPostProcessor.class,MyImportBeanDefinitionRegistrar.class, MyBeanPostProcessor.class})
public class SpringConfig {
}
