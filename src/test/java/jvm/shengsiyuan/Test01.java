package jvm.shengsiyuan;

/**
 * @author shibo
 * @date 20-3-3 下午6:04
 * +TraceClassLoading 显示类加载信息
 */
public class Test01 {
    public static void main(String[] args) {
        // 主动调用父类的静态变量，不会初始化其子类，所以子类静态代码块不会被执行
        // System.out.println(Parent01.str);
        // 主动调用子类的静态变量，会先初始化其父类，所以会先执行父类的静态代码块
        System.out.println(Child01.str);
    }
}

class Parent01 {
    public static String str = "hello parent";

    static {
        System.out.println("parent is init");
    }
}

class Child01 extends Parent01 {
    public static String str2 = "hello child";

    static {
        System.out.println("child is init");
    }
}
