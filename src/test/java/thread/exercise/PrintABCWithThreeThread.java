package thread.exercise;

public class PrintABCWithThreeThread {
    public static void main(String[] args) throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();
        MyThread3 a = new MyThread3("A",lockC,lockA);
        MyThread3 b = new MyThread3("B",lockA,lockB);
        MyThread3 c = new MyThread3("C",lockB,lockC);
        a.start();
        Thread.sleep(1000);
        b.start();
        Thread.sleep(1000);
        c.start();
        a.join();
        b.join();
        c.join();
        System.out.println("main线程结束");
    }
}

class MyThread3 extends Thread {
    private String name;
    private final Object pre;
    private final Object self;

    public MyThread3(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    public void run() {
        int i =0;
        while (i<10){
            synchronized (pre){
                synchronized (self){
                    System.out.println(name);
                    // 唤醒后一个线程的pre.wait();
                    self.notify();
                }
                try {
                    // 等待前一个线程唤醒自己
                    if(++i < 10){
                        pre.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
