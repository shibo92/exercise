package server.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by Administrator on 2022/6/29.
 * subReactor线程负责业务处理
 */
public class SubReactorThread extends ReactorThread {
    /**
     * 处理业务操作的线程
     */
    private static ExecutorService workPool = Executors.newCachedThreadPool();

    protected SubReactorThread() throws IOException {
    }

    @Override
    public void handler(SelectableChannel channel) throws Exception {
        // work线程只负责处理IO处理，不处理accept事件
        SocketChannel ch = (SocketChannel) channel;
        ByteBuffer requestBuffer = ByteBuffer.allocate(1024);
        while (ch.isOpen() && ch.read(requestBuffer) != -1) {
            // 长连接情况下,需要手动判断数据有没有读取结束 (此处做一个简单的判断: 超过0字节就认为请求结束了)
            if (requestBuffer.position() > 0) break;
        }
        if (requestBuffer.position() == 0) return; // 如果没数据了, 则不继续后面的处理
        requestBuffer.flip();
        byte[] content = new byte[requestBuffer.limit()];
        requestBuffer.get(content);
        System.out.println(new String(content));
        System.out.println(Thread.currentThread().getName() + "收到数据,来自：" + ch.getRemoteAddress());

        // TODO 业务操作 数据库、接口...
        workPool.submit(() -> {
        });

        // 响应结果 200
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Length: 11\r\n\r\n" +
                "Hello World";
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
        while (buffer.hasRemaining()) {
            ch.write(buffer);
        }
    }
}
