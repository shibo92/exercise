package thread.test;

import java.util.concurrent.*;

/**
 * @author by shibo on 2020/9/21.
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,20,1,TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.submit(new Worker1(i));
        }
        while (true) {
            int threadCount = threadPoolExecutor.getPoolSize();
            int activeCount = threadPoolExecutor.getActiveCount();
            int remainingCapacity = threadPoolExecutor.getQueue().remainingCapacity();

            System.out.println("总线程数：" + threadCount + "，当前活跃线程数：" + activeCount + "，剩余大小：" + remainingCapacity);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Worker1 implements Runnable{
    Integer index;
    Worker1(int i){
        this.index = i;
    }
    @Override
    public void run() {
        System.out.println("线程 " + index + "正在运行");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
