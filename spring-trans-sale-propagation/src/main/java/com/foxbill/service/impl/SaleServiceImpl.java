package com.foxbill.service.impl;

import com.foxbill.dao.SaleDao;
import com.foxbill.domain.Sale;
import com.foxbill.service.GoodsService;
import com.foxbill.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

                                                            //场景一
                                                            //场景二
//@Transactional(propagation = Propagation.REQUIRED)        //场景三
//@Transactional(propagation = Propagation.REQUIRED)        //场景四
//@Transactional(propagation = Propagation.REQUIRED)        //场景五
//@Transactional(propagation = Propagation.REQUIRED)        //场景六
//@Transactional(propagation = Propagation.REQUIRED)        //场景七
//@Transactional(propagation = Propagation.REQUIRED)        //场景八
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleDao saleDao;
    @Autowired
    private GoodsService goodsService;

    @Override
    public int sell(Sale sale) {
        //1.新增销售记录
        int row = saleDao.insertSale(sale);
        //2.修改库存
        goodsService.changeStore(sale.getGid(),sale.getNums());
        return row;
    }
}
