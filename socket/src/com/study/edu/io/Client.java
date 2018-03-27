package com.study.edu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Administrator on 2018/3/20.
 */
public class Client {
   /* private static int DETAULT_PORT = 8080;
    private static String DEFAULT_SERVER_IP = "172.16.73.50";
    public static void send(String expression){
        send(DETAULT_PORT,expression);
    }
    public static void send(int port,String expression){
        System.out.println("信息为："+expression);
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(DEFAULT_SERVER_IP,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out =   new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            System.out.println("结果："+in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                String s;
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (out != null){
                out.close();
                out=null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
                int i=1;
            }
        }
    }*/

    private static int DEFAULT_SERVER_PORT = 8080;
    private static String DEFAULT_SERVER_IP = "127.0.0.1";
    public static void send(String expression){
        send(DEFAULT_SERVER_PORT,expression);
    }
    public static void send(int port,String expression){
        System.out.println("算术表达式为：" + expression);
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socket = new Socket(DEFAULT_SERVER_IP,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            System.out.println("___结果为：" + in.readLine());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //一下必要的清理工作
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
