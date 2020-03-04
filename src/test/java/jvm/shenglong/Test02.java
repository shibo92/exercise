package jvm.shenglong;

/**
 * @author shibo
 * @date 20-3-4 下午10:18
 * 反编译注记符
 * ldc : 将常量池中的int,float或是String，推送到栈顶位置
 * bipush : 将单字节常量(-128 ~ 127) 推送至栈顶
 * sipush : 将短整形常量(-32768 ~ 23767) 推送至栈顶
 * iconst : 将数字 1~5 推送至栈顶
 */
public class Test02 {
    public static void main(String[] args) {
        // 此代码不会触发MyParent02的主动调用，
        // 因为str被final修饰，在编译期就存到了Test02.class的常量池中
        // 甚至在编译后将MyParent02.class文件删除，也不会影响使用
        System.out.println(MyParent02.i2);
    }
}

class MyParent02 {
    public static final String str = "hello world";
    public static final int i = 126;
    public static final int i2 = 128;

    static {
        System.out.println("hello myParent02");
    }
}