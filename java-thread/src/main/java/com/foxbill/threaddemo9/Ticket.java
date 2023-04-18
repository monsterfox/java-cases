package com.foxbill.threaddemo9;

/**
 * 买票程序 - 存在并发问题
 *
 */
public class Ticket implements Runnable{

    private int ticketNum = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {


            }
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNum--+"票");
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"小红").start();
        new Thread(ticket,"小亮").start();
    }
}
