package com.foxbill.test03;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
    自定义Connection连接类。通过适配器设计模式。完成close()方法的重写
        1.定义一个类，继承适配器父类
        2.定义Connection连接对象和连接池容器对象的变量
        3.提供有参构造方法，接收连接对象和连接池对象，对变量赋值
        4.在close()方法中，完成连接的归还
 */
public class MyConnection3 extends MyAdapter{

    //2.定义Connection连接对象和连接池容器对象的变量
    private Connection con;
    private List<Connection> pool;

    //3.提供有参构造方法，接收连接对象和连接池对象，对变量赋值
    public MyConnection3(Connection con,List<Connection> pool) {
        super(con);    // 将接收的数据库连接对象给适配器父类传递
        this.con = con;
        this.pool = pool;
    }

    //4.在close()方法中，完成连接的归还
    @Override
    public void close() throws SQLException {
        pool.add(con);
    }
}
