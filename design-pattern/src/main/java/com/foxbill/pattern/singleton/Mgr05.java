package com.foxbill.pattern.singleton;

/**
 * Lazy Loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 *
 * 可以通过synchronize解决，但也带来了效率下降
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05(){}

    public static Mgr05 getInstance(){
        if (INSTANCE == null){
            //妄图通过减小同步代码块的方式提高效率，然而不可行（这个相当于没加锁）
            synchronized (Mgr05.class) {
                //为了测试多线程中创建对象
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr05.getInstance().hashCode());
                //System.out.println(Mgr03.getInstance());
            }).start();
        }
    }
}
