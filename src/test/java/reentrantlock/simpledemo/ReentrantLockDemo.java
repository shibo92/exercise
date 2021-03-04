package reentrantlock.simpledemo;

/**
 * @author by shibo on 2020/10/20.
 */
public class ReentrantLockDemo {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;
    private static ReentrantLockDemo lock = new ReentrantLockDemo();

    public synchronized void lock()
            throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " 尝试获取锁");
        while (isLocked && lockedBy != thread) {  // 判断lockedBy是否是当前线程，如果是，则无需阻塞，且上锁次数+1
            System.out.println(Thread.currentThread().getName() + " 获取锁失败，进入阻塞状态");
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
        System.out.println(thread.getName() + " 持有锁成功，上锁次数：" + lockedCount);

    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            System.out.println(Thread.currentThread().getName() + " 解锁成功，剩余上锁次数：" + lockedCount);
            if (lockedCount == 0) {   // 上锁次数为0时，表示所有锁都已解锁，释放锁
                isLocked = false;
                notify();
            }
        }
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
