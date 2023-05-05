package com.foxbill.test07;

import com.foxbill.test07.handler.BeanHandler;
import com.foxbill.test07.handler.BeanListHandler;
import com.foxbill.test07.handler.ScalarHandler;
import com.foxbill.test07.pojo.Student;
import com.foxbill.util.DataSourceUtils;

import java.util.List;
import org.junit.Test;
public class JDBCTemplateTest {
    /*
        测试update
     */

    @Test
    public void testUpdate(){
        String sql = "insert into student values(null,?,?)";
        JDBCTemplate template = new JDBCTemplate(DataSourceUtils.getDataSource());

        int row = template.update(sql, "赵六", 20);
        System.out.println(row);
    }

    /*
        测试查询单值
     */
    @Test
    public void testQueryForObject(){
        String sql = "select * from student where id = 1";
        JDBCTemplate template = new JDBCTemplate(DataSourceUtils.getDataSource());

        Student student = template.queryForObject(sql, new BeanHandler<Student>(Student.class));
        System.out.println(student);
    }

    /*
        测试查询多值
     */
    @Test
    public void testQueryForList(){
        String sql = "select * from student";
        JDBCTemplate template = new JDBCTemplate(DataSourceUtils.getDataSource());

        List<Student> list = template.queryForList(sql, new BeanListHandler<Student>(Student.class));
        list.forEach(System.out::println);
    }

    /*
        测试聚合函数 查询
     */
    @Test
   public void testQueryForScalar(){
       String sql = "select count(*) from student";
       JDBCTemplate template = new JDBCTemplate(DataSourceUtils.getDataSource());

       Long result = template.queryForScalar(sql, new ScalarHandler<Long>());
       System.out.println(result);
   }
}
