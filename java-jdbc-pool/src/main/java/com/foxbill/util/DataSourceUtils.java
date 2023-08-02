package com.foxbill.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.foxbill.test06.DruidDemo1;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
    数据库连接池工具类
 */
public class DataSourceUtils {
    //1.私有构造方法
    private DataSourceUtils(){}

    //2.定义DataSource数据源变量
    private static DataSource dataSource;

    //3.提供静态代码块，完成配置文件的加载和获取连接池对象
    static {
        try{
            //加载配置文件
            InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties prop = new Properties();
            prop.load(is);

            //获取数据库连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(prop);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //4.提供获取数据库连接的方法
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //5.提供获取数据库连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    //6.提供释放资源的方法
    public static void close(Connection con, Statement stat, ResultSet rs) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con, Statement stat) {
        close(con,stat,null);
    }

    public static void main(String[] args) {
        System.out.println(getDataSource());
    }
}
