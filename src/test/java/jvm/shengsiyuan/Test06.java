package jvm.shengsiyuan;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author shibo
 * @date 20-3-7 下午8:18
 */
public class Test06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.count1); // 1
        System.out.println(Singleton.count2); // 0
    }
}

class Singleton {
    public static int count1;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        count1++;
        count2++;
    }
    public static int count2 = 0;


    public static Singleton getInstance(){
        return singleton;
    }
}
