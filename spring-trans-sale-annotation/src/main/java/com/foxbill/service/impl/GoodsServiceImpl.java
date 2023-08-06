package com.foxbill.service.impl;

import com.foxbill.dao.GoodsDao;
import com.foxbill.dao.SaleDao;
import com.foxbill.domain.Goods;
import com.foxbill.domain.Sale;
import com.foxbill.exception.NotEnoughException;
import com.foxbill.service.GoodsService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,
        rollbackFor = {NullPointerException.class,
                NotEnoughException.class})
public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }


    @Override
    public void buy(Integer goodsId, Integer amount) {
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(amount);
        saleDao.insertSale(sale);

        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            throw new NullPointerException("无此商品");
        }
        if (goods.getAmount() < amount){
            throw new NotEnoughException("库存不足");
        }
        goods = new Goods();
        goods.setAmount(amount);
        goods.setId(goodsId);
        goodsDao.updateGoods(goods);

    }
}
