package com.foxbill.pool;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //执行Runnalbe-1
//        service.execute(new MyRunnable());
//        service.execute(new MyRunnable());
//        service.execute(new MyRunnable());
//        service.execute(new MyRunnable());

        //执行Runnalbe-1
//        service.submit(new MyRunnable());
//        service.submit(new MyRunnable());
//        service.submit(new MyRunnable());
//        service.submit(new MyRunnable());

        //执行Callable
        Future<String> f1 = service.submit(new MyCallable());
        Future<String> f2 = service.submit(new MyCallable());
        Future<String> f3 = service.submit(new MyCallable());
        Future<String> f4 = service.submit(new MyCallable());
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());

        //2.关闭链接
        service.shutdown();



    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"~~~");
        return threadName;
    }
}

