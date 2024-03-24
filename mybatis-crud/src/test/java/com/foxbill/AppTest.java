package com.foxbill;


import com.foxbill.dao.FoodMapper;
import com.foxbill.pojo.Food;
import com.foxbill.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AppTest{
    SqlSession sqlSession = MyBatisUtil.getSqlSession();
    FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
    @Test
    public void test01() throws IOException {
        List<Food> list = foodMapper.getAllFood();
        System.out.println(list);
    }

    @Test
    public void test02(){
        Food food = new Food("11",11.0f,"gzxr.jpg");
        int i = foodMapper.addFood(food);
        sqlSession.commit();
    }


}
