package com.foxbill.dao.impl;

import com.foxbill.dao.EquipmentDao;
import org.springframework.beans.factory.InitializingBean;

public class EquipmentDaoImpl implements EquipmentDao,InitializingBean {
    @Override
    public void save() {
        System.out.println("equipment dao running...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("equipment init ... 个性化初始化后");
    }
}
