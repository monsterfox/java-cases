package com.foxbill.dao;

import com.foxbill.pojo.Food;

import java.util.List;

public interface FoodMapper {
    //查询所有菜品
    List<Food> getAllFood();

    //新增菜品
    int addFood(Food f);

    //删除菜品
    void deleteFood(int fid);

    //修改菜品
    int updateFood(Food f);

    //根据编号查询菜品
    Food getFoodByID(int fid);
}
