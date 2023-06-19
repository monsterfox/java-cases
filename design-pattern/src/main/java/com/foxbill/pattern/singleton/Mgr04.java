package com.foxbill.pattern.singleton;

/**
 * Lazy Loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 *
 * 可以通过synchronize解决，但也带来了效率下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04(){}

    public static synchronized Mgr04 getInstance(){
        if (INSTANCE == null){
            //为了测试多线程中创建对象
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
                //System.out.println(Mgr03.getInstance());
            }).start();
        }
    }
}
