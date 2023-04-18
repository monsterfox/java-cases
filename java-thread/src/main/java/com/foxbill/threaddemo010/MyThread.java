package com.foxbill.threaddemo010;

public class MyThread extends Thread {
    private static int ticketCount = 10;
    private static Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){ //就是当前的线程对象.
                if(ticketCount <= 0){
                    //卖完了
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--->拿到了第"+ticketCount+"票");
                    ticketCount--;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("小明");
        t2.setName("小红");
        t3.setName("小亮");

        t1.start();
        t2.start();
        t3.start();
    }
}
