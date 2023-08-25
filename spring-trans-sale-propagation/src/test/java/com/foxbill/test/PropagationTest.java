package com.foxbill.test;

import com.foxbill.domain.Sale;
import com.foxbill.service.SaleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagationTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01() {
        SaleService saleService = (SaleService) ctx.getBean("saleServiceImpl");
        Sale sale = new Sale(1001,10);//正常购买
        //Sale sale = new Sale(1005,10);//无此商品
        //Sale sale = new Sale(1001,200);//库存不足

        saleService.sell(sale);
    }
}
