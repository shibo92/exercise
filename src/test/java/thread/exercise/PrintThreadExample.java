package thread.exercise;

import java.util.concurrent.TimeUnit;

/**
 * @author by Administrator on 2022/4/26.
 */
public class PrintThreadExample implements Runnable {
    private String name;
    private Object next;
    private Object self;
    private Thread thread;

    public PrintThreadExample(String name, Object next, Object self) {
        this.name = name;
        this.next = next;
        this.self = self;
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        int count = 100; //2次
        while (count > 0) {
            synchronized (next) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    next.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        PrintThreadExample threadA = new PrintThreadExample("A", c, a);
        PrintThreadExample threadB = new PrintThreadExample("B", a, b);
        PrintThreadExample threadC = new PrintThreadExample("C", b, c);

        threadA.thread.start();
//        Thread.sleep(2);
        threadB.thread.start();
//        Thread.sleep(2);
        threadC.thread.start();
//        Thread.sleep(2);
    }
}
