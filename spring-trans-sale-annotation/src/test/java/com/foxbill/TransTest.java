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
        //com.foxbill.service.impl.GoodsServiceImpl@6e9175d8
        //System.out.println(goodsService); //这是一个代理对象的toString()返回值
        //class com.sun.proxy.$Proxy16
        System.out.println(goodsService.getClass()); //这是代理对象所属的Class，即当前对象（goodsService）是class com.sun.proxy.$Proxy16的对象。
        //com.sun.proxy.$Proxy16
        //System.out.println(goodsService.getClass().getName()); //这是Class的名字

//        goodsService.buy(1001,20); //正常购买
        goodsService.buy(1005,10); //无此商品
//        goodsService.buy(1001,200); //库存不足
    }
}
