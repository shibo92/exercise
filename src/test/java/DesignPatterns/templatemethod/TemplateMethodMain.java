package DesignPatterns.templatemethod;

import java.lang.reflect.Method;

/**
 * 模板方法模式
 * @author shibo
 * @date 19-12-21 下午7:01
 */
public class TemplateMethodMain {
    public static void main(String[] args) {
        Template mthodA = new MethodA();
        mthodA.doTemplateMethod();
        Template mthodB = new MethodB();
        mthodB.doTemplateMethod();
    }
}
