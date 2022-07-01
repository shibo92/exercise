package server.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by Administrator on 2022/6/29.
 * mainReactor线程负责监听连接
 */
public class MainReactorThread extends ReactorThread {
    // 1、创建多个线程 - accept线程
    private ReactorThread[] subReactorThreads;
    AtomicInteger incr = new AtomicInteger(0);

    protected MainReactorThread(ReactorThread[] subReactorThreads) throws IOException {
        this.subReactorThreads = subReactorThreads;
    }

    @Override
    public void handler(SelectableChannel channel) throws Exception {
        // 只做请求分发，不做具体的数据读取
        ServerSocketChannel ch = (ServerSocketChannel) channel;
        SocketChannel socketChannel = ch.accept();
        socketChannel.configureBlocking(false);
        // 收到连接建立的通知之后，分发给I/O线程继续去读取数据
        int index = incr.getAndIncrement() % subReactorThreads.length;
        ReactorThread workEventLoop = subReactorThreads[index];
        workEventLoop.doStart();
        SelectionKey selectionKey = workEventLoop.register(socketChannel);
        selectionKey.interestOps(SelectionKey.OP_READ);
        System.out.println(Thread.currentThread().getName() + "收到新连接 : " + socketChannel.getRemoteAddress());
    }
}
