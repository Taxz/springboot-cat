package com.study.edu.io;


import java.io.IOException;
import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2018/3/20.
 */
public class Test {
    /*public static void main(String [] agrs){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerNormal.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("aaaa");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int i=1;
                    i++;
                    Client.send(i+"hao;----");
                }
            }
        }).start();
    }*/
    public static void main(String[] args) throws InterruptedException {
        //运行服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerNormal.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Random random = new Random(System.currentTimeMillis());
        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                while(true){
                    //随机产生算术表达式
                    String expression = "test"+random.nextInt(10);
                    Client.send(expression);

                }
            }
        }).start();
}}
