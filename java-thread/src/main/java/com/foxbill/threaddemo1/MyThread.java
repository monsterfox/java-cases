package com.foxbill.threaddemo1;

/**
 * 实现多线程的方式一：继承Thread
 *  子类继承Thread类 具备多线程能力
 *  启动线程：子类对象.start()
 *  不建议使用：避免OOP单继承局限性
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        //代码就是线程在开启之后执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "第一种方式实现多线程,线程开启了" + i);
        }
    }
}
