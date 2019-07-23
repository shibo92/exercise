package thread.exercise;

public class PringABWithTwoThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-开始运行");
        Object lock = new Object();
        MyThread2 t1 = new MyThread2("0000", lock);
        MyThread2 t2 = new MyThread2("----", lock);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-结束");
    }
}

class MyThread2 extends Thread {
    private String name;
    Object lock;

    public MyThread2(String name, Object lock) {
        super(name);
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                lock.notify();
                System.out.println(name);
                try {
                    lock.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
