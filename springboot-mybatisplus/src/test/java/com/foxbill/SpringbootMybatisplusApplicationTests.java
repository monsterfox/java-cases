package com.foxbill;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import com.foxbill.util.MPLambdaWrapperUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/*

@RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解。

本人好奇@RunWith(SpringRunner.class)的作用，于是在IDEA中把这个注解去掉后发现Bean也可以通过@Autowired注解进行注入。于是比较怀疑@RunWith注解的作用

解释：
在正常情况下测试类是需要@RunWith的，作用是告诉java你这个类通过用什么运行环境运行，例如启动和创建spring的应用上下文。
否则你需要为此在启动时写一堆的环境配置代码。你在IDEA里去掉@RunWith仍然能跑是因为在IDEA里识别为一个JUNIT的运行环境，
相当于就是一个自识别的RUNWITH环境配置。但在其他IDE里并没有。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootMybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testService() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testLambda01() {
        String username = "高";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), User::getName, username).ge(ageBegin != null, User::getAge, ageBegin).le(ageEnd != null, User::getAge, ageEnd);

        System.out.println(MPLambdaWrapperUtil.getColumn(User::getName));
        System.out.println(MPLambdaWrapperUtil.getColumn(User::getAge));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);

        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());


    }

    @Test
    public void testLombokBuilder() {
        User user = User.builder().build(); //使用了 lombok 中的建造者模式构建对象
        System.out.println(user);

        User user1 = new User();
        System.out.println(user1);
    }

    /////////////////////乐观锁//////////////////////////////
    @Test
    void testConcurrentUpdate() {
        //小李
        User user1 = userMapper.selectById(1L);
        System.out.println(user1.getBalance());
        //小王
        User user2 = userMapper.selectById(1L);
        System.out.println(user2.getBalance());
        //小李将客户余额增加1000
        user1.setBalance(user1.getBalance() + 1000);
        int result1 = userMapper.updateById(user1);
        System.out.println("小李修改的结果：" + result1);
        //小王将客户余额减少500
        user2.setBalance(user2.getBalance() - 500);
        int result2 = userMapper.updateById(user2);
        System.out.println("小王修改的结果：" + result2);

        //最后的结果
        User user3 = userMapper.selectById(1L);
        //余额覆盖，最后的结果为：
        System.out.println(user3.getBalance());
    }

    @Test
    void testConcurrentVersionUpdate() {
        //小李
        User user1 = userMapper.selectById(1L);
        System.out.println(user1.getBalance());
        //小王
        User user2 = userMapper.selectById(1L);
        System.out.println(user2.getBalance());
        //小李将客户余额增加1000
        user1.setBalance(user1.getBalance() + 1000);
        int result1 = userMapper.updateById(user1);
        System.out.println("小李修改的结果：" + result1);
        //小王将客户余额减少500
        user2.setBalance(user2.getBalance() - 500);
        int result2 = userMapper.updateById(user2);
        System.out.println("小王修改的结果：" + result2);
        if (result2 == 0) {
            user2 = userMapper.selectById(1L);
            user2.setBalance(user2.getBalance() - 500);
            result2 = userMapper.updateById(user2);
        }
        System.out.println("小王重试修改的结果：" + result2);

        //最后的结果
        User user3 = userMapper.selectById(1L);
        //余额覆盖，最后的结果为：
        System.out.println(user3.getBalance());
    }

    /////////////////////////////////////代码生成器////////////////
    private static String author = "Foxbill";//作者名称
    private static String outputDir = "E:\\";//生成的位置
    private static String driver = "com.mysql.cj.jdbc.Driver";//驱动，注意版本
    //连接路径,注意修改数据库名称
    private static String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static String username = "root";//数据库用户名
    private static String password = "root";//数据库密码
    private static String tablePrefix = "t_";//数据库表的前缀，如t_user
    private static String[] tables = {"t_employee", "user"}; //生成的表
    private static String parentPackage = "com.foxbill.mybatisplus";//顶级包结构
    private static String dao = "dao";//数据访问层包名称
    private static String service = "service";//业务逻辑层包名称
    private static String entity = "entity";//实体层包名称
    private static String controller = "controller";//控制器层包名称
    private static String mapperxml = "dao";//mapper映射文件包名称

    /**
     * 代码生成 示例代码
     */
/*    @Test
    public void testGenerator() {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setAuthor(author) // 作者
                .setOutputDir(outputDir) // 生成路径
                .setFileOverride(true) // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I，加%s则不生成I
                .setBaseResultMap(true) //映射文件中是否生成ResultMap配置
                .setBaseColumnList(true); //生成通用sql字段
        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) // 设置数据库类型
                .setDriverName(driver) //设置驱动
                .setUrl(url) //设置连接路径
                .setUsername(username) //设置用户名
                .setPassword(password); //设置密码
        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix(tablePrefix) //表前缀
                .setInclude(tables); // 生成的表
        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(parentPackage)//顶级包结构
                .setMapper(dao) //数据访问层
                .setService(service) //业务逻辑层
                .setController(controller) //控制器
                .setEntity(entity) //实体类
                .setXml(mapperxml); //mapper映射文件
        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig);
        //6. 执行
        ag.execute();
    }*/

}
