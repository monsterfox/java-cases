package com.foxbill.tcp01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());

        os.close();
        socket.close();

    }
}
