package thread.stop;

class MyThread2 implements Runnable {
    volatile boolean isStop = false;
    public void run(){
        for(int i=0; i<500000; i++){
            if(!isStop) System.out.println("i="+(i+1));
        }
    }
}
public class VariableTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        // 如果不等待，则线程不会打印i的值
        Thread.sleep(6000);
        myThread2.isStop = true;
    }
}
