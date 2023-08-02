package com.foxbill.test;

import com.foxbill.test07.JDBCTemplate;
import com.foxbill.test07.handler.BeanHandler;
import com.foxbill.test07.pojo.Student;
import com.foxbill.util.DataSourceUtils;
import org.junit.Test;

public class JDBCTemplateTest {
    @Test
    public void test01(){
        String sql = "select * from student where id = 1";
        JDBCTemplate template = new JDBCTemplate(DataSourceUtils.getDataSource());

        Student student = template.queryForObject(sql, new BeanHandler<Student>(Student.class));
        System.out.println(student);
    }
}
