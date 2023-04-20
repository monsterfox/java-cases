package com.foxbill.udp04_广播;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 广播地址：255.255.255.255（只有一个）
 */

// 发送端
public class ClientDemo {
    public static void main(String[] args) throws IOException {
      	// 1. 创建发送端Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket();
		// 2. 创建存储数据的箱子,将广播地址封装进去
        String s = "广播 hello";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
		// 3. 发送数据
        ds.send(dp);
		// 4. 释放资源
        ds.close();
    }
}