package thread.exercise;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintABCByCAS {
    static AtomicInteger index = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (index.get() < 30) {
                if (index.get() % 3 == 0) {
                    System.out.println("A");
                    index.getAndIncrement();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (index.get() < 30) {
                if (index.get() % 3 == 1) {
                    System.out.println("B");
                    index.getAndIncrement();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (index.get() < 30) {
                if (index.get() % 3 == 2) {
                    System.out.println("C");
                    index.getAndIncrement();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
