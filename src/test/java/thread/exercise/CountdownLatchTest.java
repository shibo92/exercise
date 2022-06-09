package thread.exercise;

import java.util.concurrent.CountDownLatch;

/**
 * @author by Administrator on 2022/6/8.
 */
public class CountdownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println("1");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(123);
    }
}
