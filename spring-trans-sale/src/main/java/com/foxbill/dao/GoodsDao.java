package com.foxbill.dao;

import com.foxbill.domain.Goods;

public interface GoodsDao {
    int updateGoods(Goods goods);
    Goods selectGoods(Integer goodsId);
}
