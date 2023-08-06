package com.foxbill.test;

import com.foxbill.mapper.MyClassMapper;
import com.foxbill.pojo.MyClass;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CollectionTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MyClassMapper mapper = sqlSession.getMapper(MyClassMapper.class);

        List<MyClass> myClasses = mapper.selectMyClass();
        for (MyClass myClass : myClasses) {
            System.out.println(myClass);
        }

        sqlSession.close();
    }
}
