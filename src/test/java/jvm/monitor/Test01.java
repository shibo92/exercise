package jvm.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class Test01 {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 做延时处理，使监控曲线变化更明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        // gc放到这里的话，老年代中的list不会被回收，放到fillHeap之外则可以
        // System.out.println("执行完毕");
        // System.gc();
        // Thread.sleep(10000);
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.out.println("执行完毕");
        System.gc();
        Thread.sleep(10000);
    }
}
