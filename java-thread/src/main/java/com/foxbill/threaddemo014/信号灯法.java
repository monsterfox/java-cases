package com.foxbill.threaddemo014;

public class 信号灯法 {
}

//生产者->演员

//消费者->观众

//产品->节目
class TV{
    //演员表演，观众等待
    //观众观看，演员等待
    String voice; //表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice){
        System.out.println("演员表演了："+voice);
        //通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }
    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观看了："+voice);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }

}

