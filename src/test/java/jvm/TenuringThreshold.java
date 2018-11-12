package jvm;

/**
 * 长期存活直接进入老年代
 *
 * -Xms20m -Xmx20m -Xmn10 -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 */
public class TenuringThreshold {
}