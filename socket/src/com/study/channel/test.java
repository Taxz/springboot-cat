package com.study.channel;

import com.study.utill.SelectSort;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/26.
 */
public class test {

    public static void client() {
        try {
            SocketChannel cs = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
            cs.configureBlocking(false);
            Scanner scanner = new Scanner(System.in);
            ByteBuffer by = ByteBuffer.allocate(1024);
            while (scanner.hasNext()) {
                by.put(scanner.next().getBytes());
                by.flip();
                cs.write(by);
                by.clear();
            }
            cs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }

    public static void server(){
        try {
            ServerSocketChannel ss = ServerSocketChannel.open();
            ss.configureBlocking(false);
            ss.bind(new InetSocketAddress(8888));
            Selector select = Selector.open();
            ss.register(select, SelectionKey.OP_ACCEPT);
            while (select.select() > 0) {
                Iterator<SelectionKey> it = select.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    if (sk.isAcceptable()) {
                        SocketChannel cs = ss.accept();
                        cs.configureBlocking(false);
                        cs.register(select, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        SocketChannel ch = (SocketChannel) sk.channel();
                        ByteBuffer buff = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = ch.read(buff)) > 0) {
                            buff.flip();
                            System.out.println(new String(buff.array(), 0, len));
                            buff.clear();
                        }

                    }
                    it.remove();
                }
            }
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        server();
    }
}
