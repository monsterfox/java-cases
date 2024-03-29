package com.foxbill.tcp03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP程序文件上传练习
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        Socket accept = ss.accept();

        //网络中的流，从客户端读取数据的
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //本地的IO流，把数据写到本地中，实现永久化存储
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("java-network\\serverDir\\copy.jpg"));

        int b;
        while ((b = bis.read()) != -1){
            bos.write(b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        bos.flush();
        bos.close();
        accept.close();
        ss.close();


    }
}
