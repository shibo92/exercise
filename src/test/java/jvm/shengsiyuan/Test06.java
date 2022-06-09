package jvm.shengsiyuan;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author shibo
 * @date 20-3-7 下午8:18
 */
public class Test06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}

class Singleton {
    private static volatile Singleton singleton;
    private Singleton() {
    }

    public static Singleton getInstance(){
        if(null == singleton){
            synchronized (Singleton.class){
                if(null == singleton){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
