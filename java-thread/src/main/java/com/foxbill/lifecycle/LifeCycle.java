package com.foxbill.lifecycle;

public class LifeCycle implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run...Thread..."+i++);
        }
    }

    public void stop() {
        this.flag = false;
    }


    public static void main(String[] args) {
        LifeCycle lifeCycle = new LifeCycle();

        new Thread(lifeCycle,"子线程").start();

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main" + i);
            if (i == 900){
                lifeCycle.stop();
                System.out.println("子线程停止了...");
            }
        }

    }
}
