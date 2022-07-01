package server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author by Administrator on 2022/6/27.
 * NioServer 分离监听连接和数据处理
 * // 问题: 轮询通道的方式,低效,浪费CPU
 */
public class MyNioServer2 {
    public static void main(String[] args) throws IOException {
        /**
         * 已经建立连接的集合
         */
        ArrayList<SocketChannel> channels = new ArrayList<>();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8081));
        // 非阻塞
        serverSocketChannel.configureBlocking(false);
        while (true) {
            // 监听连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("收到新连接 : " + socketChannel.getRemoteAddress());
                socketChannel.configureBlocking(false);
                channels.add(socketChannel);
            } else {
                // 没有新连接的情况下,就去处理现有连接的数据,处理完的就删除掉
                Iterator<SocketChannel> iterator = channels.iterator();
                while (iterator.hasNext()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    SocketChannel ch = iterator.next();
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
                    iterator.remove();
                }
            }
        }
    }
}
