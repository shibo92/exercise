package thread.exercise;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by Administrator on 2022/4/26.
 */
public class WaitNotifyTest {


    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal();
        ThreadLocal<String> tl2 = new ThreadLocal();
        // new Thread(new Waiting4(), "Waiting4").start();
        // new Thread(new Waiting5(), "Waiting5").start();
        // new Thread(new Waiting6(), "Waiting6").start();
        tl.set("abc");
        tl2.set("bbb");
        tl2.get();
    }

    static class Waiting1 implements Runnable {
        @Override
        public void run() {
            synchronized (WaitNotifyTest.class) {
                try {
                    WaitNotifyTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // WaitNotifyTest.class.notify();
            }
            System.out.println("Waiting1 被唤醒");
        }
    }

    static class Waiting2 implements Runnable {
        @Override
        public void run() {
            synchronized (WaitNotifyTest.class) {
                try {
                    WaitNotifyTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // WaitNotifyTest.class.notify();
            }
            System.out.println(Thread.currentThread().getName() + " 被唤醒");
        }
    }

    static class Waiting3 implements Runnable {
        @Override
        public void run() {
            synchronized (WaitNotifyTest.class) {
                WaitNotifyTest.class.notify();
            }
            System.out.println("Waiting3 结束");
        }
    }

    static class Waiting4 implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting6.class) {
                    synchronized (Waiting4.class) {
                        System.out.println("A");
                        Waiting4.class.notify();
                        /*try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        // WaitNotifyTest.class.notify();
                    }
                    try {
                        Waiting6.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // System.out.println(Thread.currentThread().getName() + " 被唤醒");
            }
        }
    }

    static class Waiting5 implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting4.class) {
                    synchronized (Waiting5.class) {
                        System.out.println("B");
                        Waiting5.class.notify();
                        // WaitNotifyTest.class.notify();
                        /*try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                    try {
                        Waiting4.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // System.out.println(Thread.currentThread().getName() + " 被唤醒");
            }
        }
    }

    static class Waiting6 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Waiting5.class) {
                    synchronized (Waiting6.class) {
                        System.out.println("C");
                        Waiting6.class.notify();
                        // WaitNotifyTest.class.notify();
                        /*try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                    try {
                        Waiting5.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // System.out.println(Thread.currentThread().getName() + " 被唤醒");
            }
        }
    }

}
