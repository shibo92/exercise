package thread.create;

/**
 * @author by Administrator on 2023/2/1.
 */
public class RunnableCreate implements Runnable {
    @Override
    public void run(){
        System.out.println("create with implement");
    }

    public static void main(String[] args) {
        RunnableCreate tc = new RunnableCreate();
        new Thread(tc).start();
    }
}
