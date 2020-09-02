package DesignPatterns.DynamicProxy.mybatis;

import java.lang.reflect.Proxy;

/**
 * @author by shibo on 2020/9/2.
 */
public class Test {
    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(UserMapper.class.getClassLoader(), new Class[]{UserMapper.class}, new MyProxy());
        // 可以更方便的使用mapper.xml中的方法
        Long u = userMapper.getUserId();
    }
}
