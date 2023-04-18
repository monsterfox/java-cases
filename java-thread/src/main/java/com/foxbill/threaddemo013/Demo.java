package com.foxbill.threaddemo013;

/**
 * 小康和小薇化妆
 *      两个人都要获得“镜子”和“口红”，才能开始化妆。
 *
 * 产生死锁的原因：一个线程同时锁定多个共享资源。
 */
public class Demo {
    public static void main(String[] args) {
        Object objA_mirror = new Object();
        Object objB_lipstick = new Object();

        new Thread(()->{
            while(true){
                synchronized (objA_mirror){
                    //线程一
                    System.out.println("小康同学获得了镜子");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objB_lipstick){
                        System.out.println("小康同学获得了口红");
                        System.out.println("小康同学可以开始化妆了...啦啦啦");
                    }
                }
            }
        }).start();

        new Thread(()->{
            while(true){
                synchronized (objB_lipstick){
                    //线程二
                    System.out.println("小薇同学获得了口红");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (objA_mirror){
                        System.out.println("小薇同学获得了镜子");
                        System.out.println("小康同学可以开始化妆了...啦啦啦");
                    }
                }
            }
        }).start();
    }
}
