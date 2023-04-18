# 多线程

## threaddemo1
实现多线程的方式一：继承Thread

## threaddemo2
实现多线程的方式二：实现接口Runnable

## threaddemo3
实现多线程的方式三：实现接口Callable<T>，特点是可以返回值。

3.1：通过 Callable 和 FutureTask 创建线程。

3.2：通过Callable 和 ExecutorService 、 Future创建线程。

启动方式1：
```java
        //线程开启之后需要执行里面的call方法
        MyCallable mc = new MyCallable();

        //可以获取线程执行完毕之后的结果.也可以作为参数传递给Thread对象
        FutureTask<String> ft = new FutureTask<>(mc);

        //创建线程对象
        Thread t1 = new Thread(ft);

        //开启线程
        t1.start();

        //获取线程返回值
        String s = ft.get();
        
        System.out.println(s);
```

启动方式2：
```java
        //创建Callable实现类的对象
        ImageDownload t1 = new ImageDownload("https://www.runoob.com/wp-content/uploads/2013/06/image-icon.png", "icon.png");
        ImageDownload t2 = new ImageDownload("https://www.runoob.com/wp-content/uploads/2013/06/02A7DD95-22B4-4FB9-B994-DDB5393F7F03.jpg", "html1.jpg");
        ImageDownload t3 = new ImageDownload("https://www.runoob.com/wp-content/uploads/2013/06/EAD13C0B-0BE9-411E-8E2A-23600B0BEF9B.jpg", "html2.jpg");

        //创建执行服务 - new一个线程池
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);
        
        //获取结果
        Boolean r1 = result1.get();
        Boolean r2 = result2.get();
        Boolean r3 = result3.get();
        
        //关闭服务
        ser.shutdownNow();
```

## threaddemo4
继承Thread,如何设置线程名称

## threaddemo5
String name = Thread.currentThread().getName();

## threaddemo6
线程的默认名称：Thread-x，其中x为数字

## threaddemo7
通过实现Callable接口，实现多线程

## threaddemo8
守护线程

## threaddemo9


## threaddemo10
## threaddemo11
## threaddemo12
## threaddemo13
## threaddemo14


