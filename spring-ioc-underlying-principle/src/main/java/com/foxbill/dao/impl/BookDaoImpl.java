package com.foxbill.dao.impl;

import com.foxbill.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao running...");
    }
}
