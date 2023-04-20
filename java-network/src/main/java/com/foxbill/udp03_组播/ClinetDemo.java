package com.foxbill.udp03_组播;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP通信组播地址
 *  224.0.0.0~239.255.255.255
 *
 *  其中224.0.0.0~224.0.0.255为预留的组播地址【操作系统在用，我们用不了】
 */


// 发送端
public class ClinetDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建发送端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket();
        String s = "hello 组播";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        int port = 10000;
        // 2. 创建数据，并把数据打包(DatagramPacket)
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
        // 3. 调用DatagramSocket对象的方法发送数据(在单播中,这里是发给指定IP的电脑但是在组播当中,这里是发给组播地址)
        ds.send(dp);
        // 4. 释放资源
        ds.close();
    }
}