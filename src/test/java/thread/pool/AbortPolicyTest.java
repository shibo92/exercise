package thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor四种拒绝策略
 */
public class AbortPolicyTest {
    public static void main(String[] args) {
        // 默认是Abortlicy
        RejectedExecutionHandler executionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3), executionHandler);
        for (int i = 0; i < 20; i++) {
            executor.execute(new MyTask(i));
            System.out.println("已有线程数：" + executor.getPoolSize() + " | 活跃线程数：" + executor.getActiveCount() + " | 等待线程数：" + executor.getQueue().size() + " | 已执行线程数：" + executor.getQueue().size());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int num;

    public MyTask(int num){
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("thread - " + num + " is running ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread - " + num + " is executed !!!");
    }
}
