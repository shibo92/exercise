package jvm.shenglong;

/**
 * @author shibo
 * @date 20-3-4 下午10:18
 */
public class Test02 {
    public static void main(String[] args) {
        // 此代码不会触发MyParent02的主动调用，
        // 因为str被final修饰，在编译期就存到了Test02.class的常量池中
        // 甚至在编译后将MyParent02.class文件删除，也不会影响使用
        System.out.println(MyParent02.str);
    }
}

class MyParent02 {
    public static final String str = "hello world";

    static {
        System.out.println("hello myParent02");
    }
}