package com.foxbill.pattern.singleton;

/**
 * Lazy Loading
 * 也称为懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 *
 * 可以通过synchronize解决，但也带来了效率下降
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE; //JIT 防止指令重排

    private Mgr06(){}

    public static Mgr06 getInstance(){
        if (INSTANCE == null){
            //双重检查
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    //为了测试多线程中创建对象
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Mgr06(); //不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     *
                     * 123
                     * 132 A
                     *     B
                     */
                }
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
                System.out.println(Mgr06.getInstance().hashCode());
                //System.out.println(Mgr03.getInstance());
            }).start();
        }
    }
}
