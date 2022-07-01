package server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author by Administrator on 2022/6/27.
 * 原始版nio server
 */
public class MyNioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8081));
        // 非阻塞
        serverSocketChannel.configureBlocking(false);
        while (true) {
            // 监听连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("收到新的连接");
                socketChannel.configureBlocking(false);
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                // 循环读
                // 缺点，如果没有数据，会一直轮询等待，无法接收新的连接
                while (socketChannel.isOpen() && socketChannel.read(byteBuffer) != -1) {
                    if (byteBuffer.position() > 0) {
                        // 读到数据，跳出循环
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
                String resContent = "Hello" + socketChannel.getRemoteAddress();
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Length:" + resContent.length() +
                        "\r\n\r\n" +
                        resContent;
                ByteBuffer writeBuffer = ByteBuffer.wrap(response.getBytes());
                while (writeBuffer.hasRemaining()) {
                    socketChannel.write(writeBuffer);
                }
            }
        }
    }
}
