package jvm.shengsiyuan;

/**
 * @author shibo
 * @date 20-3-6 下午12:39
 */
public class Test04 {
    public static void main(String[] args) {
        MyParent04 myParent04 = new MyParent04();
        MyParent04[] myParent04s = new MyParent04[1];
        System.out.println(myParent04.getClass());
        System.out.println(myParent04s.getClass());
    }
}

class MyParent04{
    static {
        System.out.println("static block code");
    }
}
