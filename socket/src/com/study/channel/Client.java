package com.study.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/26.
 */
public class Client {
    public String IP;
    public int port;

    public Client(String IP, int port) {
        this.IP = IP;
        this.port = port;
    }
    public void send(){
        try {
            SocketChannel sChannel = SocketChannel.open(new InetSocketAddress(getIP(), getPort()));
            sChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
                String  str = scan.next();
                buffer.put((new Date().toString() + "\n" + str).getBytes());
                buffer.flip();
                sChannel.write(buffer);
                buffer.clear();
            }
            sChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public static void main(String agrs[]){
        Client client = new Client("127.0.0.1",8888);

        client.send();

    }
}
