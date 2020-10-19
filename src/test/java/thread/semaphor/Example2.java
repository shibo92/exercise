package thread.semaphor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Example2 {

    public static AtomicInteger count = new AtomicInteger(0);
    public static int clientTotal = 5000;
    public static int threadTotal = 3;
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 但同时只能有3个线程运行
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        // 等待所有线程执行完毕
        countDownLatch.await();
        // 线程池关闭
        executorService.shutdown();
        // 输出正常
        System.out.println(count);
    }
    private static void add() {
        count.incrementAndGet();
    }
}