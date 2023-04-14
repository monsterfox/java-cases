package com.foxbill.threaddemo2;

/**
 * 第二种方式实现多线程
 *   实现接口Runnable具体多线程能力
 *   启动线程：传入目标对象 + Thread对象.start()
 *   推荐使用：避免单继承局限性，灵活方便，方便同一个对象被多个线程使用
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        //线程启动后执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "第二种方式实现多线程" + i);
        }
    }
}
