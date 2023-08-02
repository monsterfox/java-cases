package com.foxbill.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor的参数：
 *
 * 参数一：核心线程数量
 *
 * 参数二：最大线程数
 *
 * 参数三：空闲线程最大存活时间
 *
 * 参数四：时间单位
 *
 * 参数五：任务队列
 *
 * 参数六：创建线程工厂
 *
 * 参数七：任务的拒绝策略 ----① 什么时候拒绝任务   当提交的任务 > 池子中最大线程数量 + 队列容量 ②如何拒绝
 */
public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 1; i <= 16; i++) {
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        pool.shutdown();
    }
}
