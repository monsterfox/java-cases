package com.foxbill.tcp02;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
//        os.close();//如果在这里关闭流，会导致整个socket都无法使用
        socket.shutdownOutput();//仅仅关闭输出流，并写一个结束标记，对socket没有任何影响

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
        os.close();
        socket.close();

    }
}
