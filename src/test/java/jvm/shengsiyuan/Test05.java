package jvm.shengsiyuan;

/**
 * @author shibo
 * @date 20-3-7 下午7:55
 * 初始化接口或类时，不会初始化其实现的父接口，但是会先初始化其父类
 */
public class Test05 {
    public static void main(String[] args) {
        System.out.println(MyChild05.b);
    }
}

interface MyParent05{
    public static final Thread thread = new Thread(){
        {
            System.out.println("hello world");
        }
    };
}

interface MyChild05 extends MyParent05{
    public static final String b = "waaa";
}
