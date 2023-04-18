package com.foxbill.threaddemo9;

public class Ticket_Synchronized implements Runnable {
    //票的数量
    private int ticket = 10;
    private Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){//多个线程必须使用同一把锁.
                if(ticket <= 0){
                    //卖完了
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--->拿到了第"+ticket+"票");
                    ticket--;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Ticket ticket3 = new Ticket();

        Thread t1 = new Thread(ticket1);
        Thread t2 = new Thread(ticket2);
        Thread t3 = new Thread(ticket3);*/

        Ticket_Synchronized ticket = new Ticket_Synchronized();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("小明");
        t2.setName("小红");
        t3.setName("小亮");

        t1.start();
        t2.start();
        t3.start();
    }
}
