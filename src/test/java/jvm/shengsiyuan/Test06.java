package jvm.shengsiyuan;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author shibo
 * @date 20-3-7 下午8:18
 */
public class Test06 {
    public static void main(String[] args) {
        // Singleton singleton = Singleton.getInstance();
        // System.out.println(singleton);
        ThreadTest test0 = new ThreadTest();
        ThreadTest test1 = new ThreadTest();
        Thread t0 = new Thread(test0);
        Thread t1 = new Thread(test1);
        t0.start();
        t1.start();

    }
}

class ThreadTest implements Runnable {
    ThreadTest test0 = new ThreadTest();

    @Override
    public void run() {
        synchronized (test0) {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

