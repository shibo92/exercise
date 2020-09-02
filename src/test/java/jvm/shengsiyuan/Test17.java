package jvm.shengsiyuan;

/**
 * @author by shibo on 2020/4/28.
 */
public class Test17 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("我的classloader");
        Class<?> clazz = myClassLoader.loadClass("jvm.shengsiyuan.Animal");
        System.out.println(clazz.hashCode());
        // 如果不调用Animal的newInstance，则不会对cat进行主动使用
        // 也就不会进行加载
        // 但是有些情况下，jvm会对class进行预加载
        clazz.newInstance();
    }
}


class Animal {
    public Animal() {
        System.out.println("class animal is loaded by" + this.getClass().getClassLoader());
        new Cat();
    }
}

class Cat {
    public Cat() {
        System.out.println("class cat is loaded by" + this.getClass().getClassLoader());
    }
}