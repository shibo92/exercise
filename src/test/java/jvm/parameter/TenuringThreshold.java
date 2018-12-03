package jvm.parameter;

import sun.misc.GC;

/**
 * 长期存活的对象进入到老年代
 *
 * eden内存不够的时候，会进行Minor gc，
 * 年龄没达到MaxTenuringThreshold时，把存活对象放到survivor-from中，
 * 达到的对象进入老年代
 *
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1
 */
public class TenuringThreshold {
    private static final int MB_1 = 1024 * 1024;
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[MB_1 / 4];
        allocation2 = new byte[MB_1 * 4];
        allocation3 = new byte[MB_1 * 4];
        allocation3 = null;
        allocation3 = new byte[MB_1 * 4];
    }
}
