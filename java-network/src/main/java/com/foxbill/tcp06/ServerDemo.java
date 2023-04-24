package com.foxbill.tcp06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TCP程序文件上传练习--服务器优化
 *  优化方案四-需求：使用多线程虽然可以让服务器同时处理多个客户端请求。但是资源消耗太大。
 *      解决方案：加入线程池
 *      
 */

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数量
                10,//线程池的总数量
                60,//临时线程空闲时间
                TimeUnit.SECONDS,//临时线程空闲时间的单位
                new ArrayBlockingQueue<>(5),//阻塞队列
                Executors.defaultThreadFactory(),//创建线程的方式
                new ThreadPoolExecutor.AbortPolicy() //任务拒绝策略
        );

        while (true) {
            Socket accept = ss.accept();
            ThreadSocket ts = new ThreadSocket(accept);

            //new Thread(ts).start();
            pool.submit(ts);
        }
        //ss.close();

    }
}

//线程任务类
class ThreadSocket implements Runnable{

    private Socket accpetSocket;

    public ThreadSocket(Socket accpetSocket) {
        this.accpetSocket = accpetSocket;
    }

    @Override
    public void run() {
        //网络中的流，从客户端读取数据的
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(accpetSocket.getInputStream());
            //本地的IO流，把数据写到本地中，实现永久化存储
            bos = new BufferedOutputStream(new FileOutputStream("java-network\\serverDir\\"+ UUID.randomUUID().toString() +".jpg"));

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accpetSocket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accpetSocket != null){
                try {
                    accpetSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
