package com.foxbill.test04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDataSourceTest {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        MyDataSource dataSource = new MyDataSource();

        System.out.println("使用之前连接池数量：" + dataSource.getSize());

        //获取数据库连接对象
        Connection conn = dataSource.getConnection();
        System.out.println(conn.getClass()); //com.sun.proxy.$Proxy0

        //查询学生表全部信息
        String sql = "SELECT * FROM student";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t");
        }

        //释放资源
        rs.close();
        pst.close();
        //目前的连接对象close方法，是直接关闭连接，而不是将连接归还池中
        conn.close();

        System.out.println("使用之后连接池数量：" + dataSource.getSize());


    }
}
