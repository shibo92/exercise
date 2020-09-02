package DesignPatterns.DynamicProxy.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author by shibo on 2020/9/2.
 */
public class CommonProxy implements InvocationHandler {
    private Object proxyObj;

    CommonProxy(Object proxyObj) {
        this.proxyObj = proxyObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理");
        Object invoke = method.invoke(proxyObj, args);
        System.out.println("代理结束");
        return invoke;
    }
}
