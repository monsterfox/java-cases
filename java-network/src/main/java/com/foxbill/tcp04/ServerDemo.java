package com.foxbill.tcp04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * TCP程序文件上传练习--服务器优化
 *  优化方案一-需求：服务器只能处理一个客户端请求，接收完一个图片之后，服务器就关闭了。
 *      解决方案：使用循环
 *  优化方案二-需求：第二次上传文件的时候，会把第一次的文件给覆盖。
 *      解决方案：UUID. randomUUID()方法生成随机的文件名
 *
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();

            //网络中的流，从客户端读取数据的
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            //本地的IO流，把数据写到本地中，实现永久化存储
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("java-network\\serverDir\\"+ UUID.randomUUID().toString() +".jpg"));

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();

            bos.flush();
            bos.close();
            accept.close();
        }
        //ss.close();


    }
}
