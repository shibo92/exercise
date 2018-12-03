package jvm.parameter;

/**
 * 大对象直接进入老年代
 * -Xms:20m -Xmx:20m -Xmn:10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728(b)
 *
 * -XX:PretenureSizeThreshold=3145728(b) 设置大对象阈值大小为3M
 */
public class PretenureSizeThreshold {
    private static final int MB_1 = 1024 * 1024;
    public static void main(String[] args) {
        // 直接分配到老年代
        byte[] allocation = new byte[MB_1 * 6];
    }
}
