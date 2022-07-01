package server.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/**
 * @author by Administrator on 2022/6/24.
 */
public class MyNioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 8081));
        while (!socketChannel.finishConnect()) {
            Thread.yield();
        }
        System.out.print("请输入：");
        Scanner scan = new Scanner(System.in);
        ByteBuffer byteBuffer = ByteBuffer.wrap(scan.nextLine().getBytes());
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        while (socketChannel.isOpen() && socketChannel.read(readBuffer) != -1) {
            if (readBuffer.position() > 0) break;
        }
        readBuffer.flip();
        byte[] content = new byte[readBuffer.limit()];
        readBuffer.get(content);
        System.out.println(new String(content));
        socketChannel.close();
    }
}
