package com.zhukai.demo.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功");
            new Thread(new ServerThread(socket)).start();
        }
    }
}
class ServerThread implements Runnable {

    private Socket client;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {


            PrintStream out = new PrintStream(client.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            boolean flag = true;
            while (flag) {

                String s = bufferedReader.readLine();

                if (s == null || "".equals(s)) {
                    flag = false;
                }else {
                    if ("bye".equals(s)) {
                        flag = false;
                    } else {
                        out.println("get");
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}