package jvm.shengsiyuan;

/**
 * @author shibo
 * @date 20-3-7 下午7:55
 */
public class Test05 {
    public static void main(String[] args) {
        System.out.println(MyChild05.b);
    }
}

interface MyParent05{
    int a = 5;
}

interface MyChild05 extends MyParent05{
    int b = 6;
}
