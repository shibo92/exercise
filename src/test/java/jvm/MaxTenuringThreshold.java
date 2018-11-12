package jvm;

/**
 * 长期存活的对象进入到老年代
 *
 * -Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1
 */
public class MaxTenuringThreshold {

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[Allocation.MB_1 / 4];
        allocation2 = new byte[Allocation.MB_1 * 4];
        allocation3 = new byte[Allocation.MB_1 * 4];
        allocation3 = null;
        allocation3 = new byte[Allocation.MB_1 * 4];
    }
}
