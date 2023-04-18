package com.foxbill.threaddemo8;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true){
            System.out.println(getName() + "---" + i++);
        }
    }
}
