package reentrantlock.simpledemo;

/**
 * @author by shibo on 2020/10/20.
 */
public class NoReentrantLockDemo {
    private boolean isLocked = false;
    public static NoReentrantLockDemo lock = new NoReentrantLockDemo();

    public synchronized void lock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 尝试获取锁");
        while (isLocked) {
            System.out.println(Thread.currentThread().getName() + " 获取锁失败，进入阻塞状态");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " 持有锁成功");
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void method2() throws InterruptedException {
        lock.lock();
        System.out.println("do some thing.");
        lock.unlock();
    }

    private static void method1() throws InterruptedException {
        lock.lock();
        method2();
        lock.unlock();
    }
}
