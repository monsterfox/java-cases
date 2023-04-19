package com.foxbill.threaddemo014;

import java.util.Random;

//测试：生产者消费者模型 --> 利用缓冲区解决：管程法
//生产者，消费者，产品，缓冲区
/*
    疑问1：有可能出现，先消费，再生产的情况。比如：还未生产第6只鸡，却先消费了第6只鸡
 */

public class 管程法 {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }

}

//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    //生产
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            container.push(new Chicken(i));
            /*
                出现疑问1的原因分析：
                    下面这行代码可能出现：上一行代码执行后，线程进入等待状态，导致下面的代码未执行的情况。
                    即，鸡已经放入容器，但是没有输出如下的提示信息。导致，看起来像，未生产先消费的情况。
             */
            //System.out.println("生产第"+i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //消费
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("消费第"+container.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //需要一个容器
    Chicken[] chickens = new Chicken[5];
    //容器计数器（容器中产品的数量）
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要等待消费者消费
        if (count == chickens.length){
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //如果容器没有满，我们就需要丢入产品
        chickens[count] = chicken;
        System.out.println("生产第"+chicken.id+"只鸡");//疑问1:
        count++;
        //可以通知消费者消费了
        this.notifyAll();

    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
         if(count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完了，通知生产者生产
        this.notifyAll();

        return chicken;

    }
}

