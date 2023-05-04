package com.foxbill.test05;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *     开源连接池-1：使用C3P0连接池
 *     1.导入jar包
 *     2.导入配置文件到resources下
 *     3.创建c3p0连接池对象
 *     4.获取数据库连接进行使用
 */
public class C3P0Demo01 {
    public static void main(String[] args) throws Exception{
        //创建c3p0连接池对象
        DataSource dataSource = new ComboPooledDataSource();

        //获取数据库连接进行使用
        Connection con = dataSource.getConnection();

        //查询全部学生信息
        String sql = "SELECT * FROM student";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" );
        }

        //释放资源
        rs.close();
        pst.close();
        con.close();    // 将连接对象归还池中
    }
}
