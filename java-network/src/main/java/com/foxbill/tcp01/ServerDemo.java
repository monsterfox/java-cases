package com.foxbill.tcp01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.print((char)b);
        }
        System.out.println("看看我执行了吗");

        is.close();
        ss.close();

    }
}
