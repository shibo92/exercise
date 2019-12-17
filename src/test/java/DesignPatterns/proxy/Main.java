package DesignPatterns.proxy;

/**
 * @author shibo
 * @date 19-12-17 下午2:48
 */
public class Main {
    public static void main(String[] args) {
        Girl girl = new Girl("妹子");
        Proxy proxy = new Proxy(girl);
        proxy.proxy();
    }
}
