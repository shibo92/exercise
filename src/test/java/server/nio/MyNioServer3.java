package server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author by Administrator on 2022/6/27.
 * <p>
 * NioServer多线程版
 */
public class MyNioServer3 {
    public static void main(String[] args) throws IOException {
        /**
         * 已经建立连接的集合
         */
        CopyOnWriteArrayList<SocketChannel> channels = new CopyOnWriteArrayList<>();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8081));
        // 非阻塞
        serverSocketChannel.configureBlocking(false);
        new Thread(() -> {
            while (true) {
                // 监听连接
                SocketChannel socketChannel = null;
                try {
                    socketChannel = serverSocketChannel.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (socketChannel != null) {
                    try {
                        System.out.println("收到新连接 : " + socketChannel.getRemoteAddress());
                        socketChannel.configureBlocking(false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    channels.add(socketChannel);
                }
            }
        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    // 没有新连接的情况下,就去处理现有连接的数据,处理完的就删除掉
                    for (int i = 0; i < channels.size(); i++) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        SocketChannel ch = channels.get(i);
                        // 解决了没有数据读取时，一直轮询等待的缺点
                        if (ch.read(byteBuffer) == 0) {
                            // 等于0,代表这个通道没有数据需要处理,那就待会再处理
                            continue;
                        }

                        // 循环读
                        while (ch.isOpen() && ch.read(byteBuffer) != -1) {
                            if (byteBuffer.position() > 0) {
                                // 说明读到数据了
                                break;
                            }
                        }
                        if (byteBuffer.position() == 0) {
                            continue;
                        }
                        byteBuffer.flip();
                        byte[] content = new byte[byteBuffer.limit()];
                        byteBuffer.get(content);
                        System.out.println("读取数据完毕,content:" + new String(content));
                        String resContent = "Hello" + ch.getRemoteAddress();
                        String response = "HTTP/1.1 200 OK\r\n" +
                                "Content-Length:" + resContent.length() +
                                "\r\n\r\n" +
                                resContent;
                        ByteBuffer writeBuffer = ByteBuffer.wrap(response.getBytes());
                        while (writeBuffer.hasRemaining()) {
                            ch.write(writeBuffer);
                        }
                        channels.remove(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}