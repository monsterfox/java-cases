package com.foxbill.test07;

import com.foxbill.test07.handler.ResultSetHandler;
import com.foxbill.util.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
    private DataSource dataSource;
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //专用于执行增删改sql语句的方法
    public int update(String sql,Object...objs) {
        int result = 0;

        try{
            con = dataSource.getConnection();
            pst = con.prepareStatement(sql);

            //获取sql语句中的参数源信息
            ParameterMetaData pData = pst.getParameterMetaData();
            //获取sql语句中参数的个数
            int parameterCount = pData.getParameterCount();

            //判断参数个数是否一致
            if(parameterCount != objs.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句中的?占位符赋值
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i+1,objs[i]);
            }

            //执行sql语句
            result = pst.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DataSourceUtils.close(con,pst);
        }

        //返回结果
        return result;
    }

    /*
    	专用于执行查询一条记录sql语句的方法
    */
    public <T> T queryForObject(String sql, ResultSetHandler<T> rsh, Object...objs) {
        T obj = null;
        try{
            con = dataSource.getConnection();
            pst = con.prepareStatement(sql);

            //获取sql语句中的参数源信息
            ParameterMetaData pData = pst.getParameterMetaData();
            int parameterCount = pData.getParameterCount();

            //判断参数个数是否一致
            if(parameterCount != objs.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句中的?占位符赋值
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i+1,objs[i]);
            }

            //执行sql语句
            rs = pst.executeQuery();

            //通过BeanHandler方式对结果进行处理
            obj = rsh.handler(rs);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DataSourceUtils.close(con,pst,rs);
        }

        //将结果返回
        return obj;
    }

    /*
        专用于查询所有记录sql语句的方法
    */
    public <T> List<T> queryForList(String sql,ResultSetHandler<T> rsh,Object...objs){
        List<T> list = new ArrayList<>();
        try{
            con = dataSource.getConnection();
            pst = con.prepareStatement(sql);

            //获取sql语句中的参数源信息
            ParameterMetaData pData = pst.getParameterMetaData();
            int parameterCount = pData.getParameterCount();

            //判断参数个数是否一致
            if(parameterCount != objs.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句中的?占位符赋值
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i+1,objs[i]);
            }

            //执行sql语句
            rs = pst.executeQuery();

            //通过BeanListHandler方式对结果进行处理
            list = rsh.handler(rs);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DataSourceUtils.close(con,pst,rs);
        }
        return list;
    }

    /*
        专用于执行聚合函数sql语句的方法
     */
    public Long queryForScalar(String sql,ResultSetHandler<Long> rsh,Object...objs){
        Long result = null;
        try{
            con = dataSource.getConnection();
            pst = con.prepareStatement(sql);

            //获取sql语句中的参数源信息
            ParameterMetaData pData = pst.getParameterMetaData();
            int parameterCount = pData.getParameterCount();

            //判断参数个数是否一致
            if(parameterCount != objs.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句中的?占位符赋值
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i+1,objs[i]);
            }

            //执行sql语句
            rs = pst.executeQuery();

            //通过ScalarHandler方式对结果进行处理
            result = rsh.handler(rs);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            //释放资源
            DataSourceUtils.close(con,pst,rs);
        }
        //将结果返回
        return result;
    }

}
