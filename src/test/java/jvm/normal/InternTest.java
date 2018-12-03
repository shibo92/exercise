package jvm.normal;

import org.junit.Test;

public class InternTest {
    @Test
    public void test() {
        /**
         * intern() 在1.6会将字符串复制一份到永久代，并返回永久代实例的引用
         * 在1.7则不会复制实例，只是将实例的引用记录到常量池，并返回此引用
         * 详见《深入理解Java虚拟机》p57
         */
        /**
         * Version类定义的私有静态字符串常量如下：
         * private static final String launcher_name = "java";
         * private static final String java_version = "1.7.0_51";
         * private static final String java_runtime_name = "Java(TM) SE Runtime Environment";
         * private static final String java_runtime_version = "1.7.0_51-b13";
         * 在初始化Version类时，对其静态常量字段根据指定的常量值做默认初始化，所以"java"被加载到了字符串常量池中
         */
        String str1 = new StringBuilder("ja").append("va").toString();
        // 为false
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("计算机").append("软件").toString();
        // 为true
        System.out.println(str2.intern() == str2);
    }
}
