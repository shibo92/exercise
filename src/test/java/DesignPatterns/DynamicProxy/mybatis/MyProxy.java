package DesignPatterns.DynamicProxy.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author by shibo on 2020/9/2.
 */
public class MyProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入mybatis代理");
        System.out.println("mybatis代理啥也没干");
        System.out.println("mybatis代理结束");
        return null;
    }
}
