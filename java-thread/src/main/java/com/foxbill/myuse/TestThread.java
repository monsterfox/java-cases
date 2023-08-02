package com.foxbill.myuse;

public class TestThread {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread threadA = new Thread(mr,"线程A");
        Thread threadB = new Thread(mr,"线程B");
        System.out.println(threadA.getState());
        System.out.println(threadB.getState());
        threadA.start();
        //threadB.start();
        System.out.println(threadA.getState());
        System.out.println(threadB.getState());

    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            if (i == 50){
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
