package com.foxbill.dao.impl;

import com.foxbill.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("Account dao running ...");
    }
}
