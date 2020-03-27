package jvm.shengsiyuan;

/**
 * @author shibo
 * @date 20-3-25 下午3:32
 */
public class Test13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
