package com.study.edu.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/3/20.
 */
public final class ServerNormal {
    private static int DEFAULT_PORT = 8080;
    private static ServerSocket server;
    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }
    public synchronized static void start(int port) throws IOException {
        if(server != null) return;
        try {
            server = new ServerSocket(port);
            System.out.println("服务器已经启动，"+port);
            while (true){
                Socket socket = server.accept();
                System.out.println("收到了");
                new Thread(new ServerHandler(socket)).start();
            }
        }finally {
            if (server != null){
                System.out.println("服务器已经关闭");
                server.close();
                server = null;
            }
        }
    }

}
