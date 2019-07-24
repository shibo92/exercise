package thread.exercise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABCByCondition {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 10) {
                lock.lock();
                System.out.println("A");
                try {
                    conditionB.signal();
                    if (i != 10) {
                        conditionA.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 10) {
                lock.lock();
                System.out.println("B");
                try {
                    conditionC.signal();
                    if (i != 10) {
                        conditionB.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            int i = 0;
            while (i++ < 10) {
                lock.lock();
                System.out.println("C");
                try {
                    conditionA.signal();
                    if (i != 10) {
                        conditionC.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
