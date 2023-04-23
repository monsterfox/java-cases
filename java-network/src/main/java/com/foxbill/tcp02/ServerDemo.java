package com.foxbill.tcp02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.print((char)b);
        }

        System.out.println("看看我执行了吗");

        OutputStream os = accept.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("你谁啊");

        bw.close();
        is.close();
        ss.close();

    }
}
