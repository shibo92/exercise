package DesignPatterns.DynamicProxy.common;

import java.lang.reflect.Proxy;

/**
 * @author by shibo on 2020/9/2.
 */
public class Test {
    public static void main(String[] args) {
        // 代理一个男生
        CommonProxy invocationHandler = new CommonProxy(new Boy());
        Human human = (Human) Proxy.newProxyInstance(Human.class.getClassLoader(), Boy.class.getInterfaces(), invocationHandler);
        // 不直接调用boy的方法
        human.talk();
    }
}
