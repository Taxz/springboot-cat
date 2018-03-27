package com.study.channel;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/3/26.
 */
public class Server {
    public static void recive(){
        try (ServerSocketChannel open = ServerSocketChannel.open()) {
            open.configureBlocking(false);
            open.bind(new InetSocketAddress(8888));
            Selector select = Selector.open();
            open.register(select, SelectionKey.OP_ACCEPT);
            while(select.select()>0){
                Iterator<SelectionKey> it = select.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    if (sk.isAcceptable()) {
                        SocketChannel cs = open.accept();
                        cs.configureBlocking(false);
                        cs.register(select, SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        SocketChannel cs = (SocketChannel) sk.channel();
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = cs.read(buf)) > 0) {
                            buf.flip();
                            System.out.println(new String(buf.array(), 0, len));
                            buf.clear();
                        }
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        recive();
    }
}
