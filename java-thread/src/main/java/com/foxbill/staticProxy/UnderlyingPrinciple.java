package com.foxbill.staticProxy;

/**
 * 多线程的底层原理
 */
public class UnderlyingPrinciple {
    public static void main(String[] args) {
        Traveller traveller = new Traveller();//旅客
        TravelAgency travelAgency = new TravelAgency(traveller);//旅行社
        travelAgency.travel();

        /////////////多线程的底层原理，跟静态代理类似//////////////
        /*
            Lambda表达式的返回值，相当于一个匿名内部类
         */
        new Thread(()->{System.out.println("我爱旅游");}).start();
        //上面的旅行代码可以简化为：
        new TravelAgency(new Traveller()).travel();
    }
}

/**
 * 旅游接口
 */
interface travel{
    void travel();
}

/**
 * 旅客 - 目标类
 */
class Traveller implements travel{
    @Override
    public void travel() {
        System.out.println("旅客：开心旅行，享受生活~");
    }
}


/**
 * 旅行社 - 代理类
 */
class TravelAgency implements travel{
    //目标对象
    private Traveller traveller;

    public TravelAgency(Traveller traveller) {
        this.traveller = traveller;
    }

    @Override
    public void travel() {
        before();
        traveller.travel();
        after();
    }

    private void after() {
        System.out.println("旅行社：酒店退订，收尾款等");
    }

    private void before() {
        System.out.println("旅行社：旅行攻略，订酒店，购买门票等");
    }




}

