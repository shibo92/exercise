package jvm.monitor;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTest {

    // 实例变量不会被回收，堆内存会一直增加
    // byte[] b = new byte[128 * 1024];

    public JConsoleTest(){
        // 局部变量会被jvm回收
        byte[] b = new byte[128 * 1024];
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(4000);
        List<JConsoleTest> l = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            l.add(new JConsoleTest());
        }
    }
}
