package thread.create;

/**
 * @author by Administrator on 2023/2/1.
 */
public class ThreadCreate extends Thread {
    @Override
    public void run(){
        System.out.println("create with extends");
    }

    public static void main(String[] args) {
        ThreadCreate tc = new ThreadCreate();
        tc.start();
    }
}
