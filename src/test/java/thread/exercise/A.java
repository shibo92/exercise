package thread.exercise;

/**
 * @author by Administrator on 2022/5/7.
 */
public class A implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                System.out.println("进入等待");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
