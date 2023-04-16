package com.foxbill.state;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程的六种状态：
 * NEW：通过 new 关键字创建
 * RUNNABLE：调用 start()
 * BLOCKED：被阻塞等待监视器锁定的线程处于此状态
 * WAITING：正在等待另一个线程执行特定动作的线程处于此状态。
 * TIMED_WAITING：正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。
 * TERMINATED：已退出的线程处于此状态。
 *
 */
public class ThreadState {

    public static void m() {
        LockSupport.park();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void n() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> m(), "线程1");

        // thread 线程执行了 new  ，观察 NEW  状态
        System.out.println(thread.getName() + " new 之后的状态：" + thread.getState());

        // thread 线程执行了 start  ，观察 RUNNABLE  状态
        thread.start();
        System.out.println(thread.getName() + " start 方法之后：" + thread.getState());

        // thread 线程执行了 LockSupport.park()  ，观察 WAITING  状态
        Thread.sleep(500);
        System.out.println(thread.getName() + " LockSupport.park() 之后的状态：" + thread.getState());
        LockSupport.unpark(thread); //唤醒线程

        // thread 线程执行了 sleep(long)  ，观察 TIMED_WAITING  状态
        Thread.sleep(500);
        System.out.println(thread.getName() + " sleep(long) 之后的状态：" + thread.getState());

        // thread 执行结束 ，观察 TERMINATED  状态
        thread.join();
        System.out.println(thread.getName() + " 执行完成的状态：" + thread.getState());


        //测试 BLOCKED 状态
        Thread thread2 = new Thread(() -> n(), "线程2");
        Thread thread3 = new Thread(() -> n(), "线程3");
        thread2.start();
        Thread.sleep(500);// 让 thread2 先执行
        thread3.start();
        Thread.sleep(500); //保证 thread 已经执行
        System.out.println(thread3.getName() + " 执行完成的状态：" + thread3.getState());

    }
}

