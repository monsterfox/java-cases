package com.foxbill.dao.impl;

import com.foxbill.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("User Dao running...");
    }
}
