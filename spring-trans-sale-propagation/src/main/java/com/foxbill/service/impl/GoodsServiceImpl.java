package com.foxbill.service.impl;

import com.foxbill.dao.GoodsDao;
import com.foxbill.domain.Goods;
import com.foxbill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
                                                            //场景一
@Transactional(propagation = Propagation.REQUIRED)          //场景二
                                                            //场景三
//@Transactional(propagation = Propagation.NOT_SUPPORTED)   //场景四
//@Transactional(propagation = Propagation.SUPPORTS)        //场景五
//@Transactional(propagation = Propagation.REQUIRES_NEW)    //场景六
//@Transactional(propagation = Propagation.REQUIRED)        //场景七
//@Transactional(propagation = Propagation.NEVER)           //场景八
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;


    @Override
    public void changeStore(Integer goodsId, Integer amount) {
        Goods goods = new Goods();
        goods.setAmount(amount);
        goods.setId(goodsId);
        goodsDao.updateGoods(goods);
        System.out.println(1/0);
    }
}
