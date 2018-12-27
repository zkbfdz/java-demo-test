package com.zhukai.demo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 2000);

        client.setSoTimeout(10000);

        //获取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //获取socket输出流,向服务端发送数据
        PrintStream out = new PrintStream(client.getOutputStream());

        //获取socket输入流,从服务端读取数据
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        boolean flag = true;

        while (flag) {
            System.out.print("输入信息:");

            String str = input.readLine();

            out.println(str);

            if ("".equals(str)) {
                continue;
            }
            if ("bye".equals(str)) {
                flag = false;
            } else {
                String echo = in.readLine();
                System.out.println(echo);
            }
        }

        input.close();
        if (client != null) {
            client.close();
        }
    }
}
