package jvm;

/**
 * * 对象优先在Eden分配，大小不够用时进行minor gc
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * 最大堆内存20M 初始堆内存20M（不可扩展)
 * 新生代10M
 */
public class Allocationa {

    public static final int MB_1 = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allcation1, allcation2, allcation3, allcation4;
        allcation1 = new byte[2 * MB_1];
        allcation2 = new byte[2 * MB_1];
        allcation3 = new byte[2 * MB_1];
        allcation4 = new byte[4 * MB_1];
    }
}
