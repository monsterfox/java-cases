package com.foxbill.test06;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
    开源连接池-2：Druid连接池
    1.导入jar包
    2.编写配置文件，放在resources目录下
    3.通过Properties集合加载配置文件
    4.通过Druid连接池工厂类获取数据库连接池对象
    5.获取数据库连接，进行使用
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception{
        //通过Properties集合加载配置文件
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties prop = new Properties();
        prop.load(is);

        //通过Druid连接池工厂类获取数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接，进行使用
        Connection con = dataSource.getConnection();

        //查询全部学生信息
        String sql = "SELECT * FROM student";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t");
        }

        //释放资源
        rs.close();
        pst.close();
        con.close();    // 将连接对象归还池中
    }
}
