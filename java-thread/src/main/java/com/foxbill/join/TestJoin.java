package com.foxbill.join;

public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin,"线程VIP");
        thread.start();
        System.out.println(thread.getPriority());
        System.out.println(Thread.currentThread().getPriority());

        //主线程
        for (int i = 0; i < 1000; i++) {
            if (i == 200){
                thread.join();//插队
            }
            System.out.println(thread.getName()+":"+thread.getState());
            System.out.println("main=" + i);
        }
    }
}
