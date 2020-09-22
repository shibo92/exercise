package thread.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by shibo on 2020/9/13.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 阿里规范不推荐Executor
         */
        ExecutorService executors = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger i = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "myThread + " + i.getAndIncrement());
            }
        });
        // 允许回收线程，抛出异常，因为executors的keepAliveTime=0
        // ((ThreadPoolExecutor) executors).allowCoreThreadTimeOut(true);
        TimeUnit.SECONDS.sleep(4);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("提交任务 ：" + i);
            executors.submit(new Worker(i));
            if(i== Integer.MAX_VALUE){
                System.out.println("任务输入完毕");
            }
        }
        /*ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(2, new ThreadFactory() {
            private AtomicInteger i = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "myThread + " + i.getAndIncrement());
            }
        });
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Worker2(i));
        }*/
        while (true) {

            int threadCount = ((ThreadPoolExecutor) executors).getPoolSize();
            int activeCount = ((ThreadPoolExecutor) executors).getActiveCount();
            int remainingCapacity = ((ThreadPoolExecutor) executors).getQueue().remainingCapacity();
/*            int threadCount = threadPoolExecutor.getPoolSize();
            int activeCount = threadPoolExecutor.getActiveCount();*/

            System.out.println("总线程数：" + threadCount + "，当前活跃线程数：" + activeCount + "，剩余大小：" + remainingCapacity);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Worker2 implements Runnable {
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public Worker2(int index) {
        this.currentIndex.set(index);
        Thread.currentThread().setName("myThread--" + index);
    }

    public AtomicInteger getCurrintIndex() {
        return this.currentIndex;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程index： " + currentIndex + " ==> " + Thread.currentThread().getName());
    }
}

class Worker implements Callable {
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public Worker(int index) {
        this.currentIndex.set(index);
    }

    @Override
    public Object call() throws Exception {
        System.out.println("当前线程index： " + currentIndex + " ==> " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(60);
        return null;
    }
}
