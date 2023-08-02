package com.foxbill.tcp01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket:所谓套接字(Socket)，就是对网络中不同主机上的应用进程之间进行双向通信的端点的抽象。
 * 一个套接字就是网络上进程通信的一端，提供了应用层进程利用网络协议交换数据的机制。
 * 从所处的地位来讲，套接字上联应用进程，下联网络协议栈，是应用程序通过网络协议进行通信的接口，是应用程序与网络协议栈进行交互的接口 [1]  。
 *
 * 百度百科：https://baike.baidu.com/item/%E5%A5%97%E6%8E%A5%E5%AD%97/9637606?fromtitle=socket&fromid=281150&fr=aladdin
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());

        os.close();
        socket.close();

    }
}
