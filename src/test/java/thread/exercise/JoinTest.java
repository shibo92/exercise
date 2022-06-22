package thread.exercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class JoinTest {
    public static void main(String[] args) throws Exception {
        /*FutureTask<Object> futureTask = new FutureTask<>((() -> 1));
        futureTask.run();
        System.out.println(futureTask.get());
        System.out.println(futureTask.get());*/


        /*System.out.println(Thread.currentThread().getName() + "-开始运行");
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();
        MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");
        MyThread t3 = new MyThread("C");
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-结束");*/
    }
}

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}