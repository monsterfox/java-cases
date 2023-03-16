package com.foxbill;

import com.foxbill.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransTest {
    @Test
    public void testBuy(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        GoodsService goodsService = (GoodsService) ctx.getBean("goodsService");
//        goodsService.buy(1001,20); //正常购买
//        goodsService.buy(1005,10); //无此商品
        goodsService.buy(1001,200); //库存不足
    }
}
