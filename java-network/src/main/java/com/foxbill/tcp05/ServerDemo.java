package com.foxbill.tcp05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * TCP程序文件上传练习--服务器优化
 *  优化方案三-需求：使用循环虽然可以让服务器处理多个客户端请求。但是还是无法同时跟多个客户端进行通信。
 *      解决方案：开启多线程处理
 *      
 */

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();
            ThreadSocket ts = new ThreadSocket(accept);
            new Thread(ts).start();
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
