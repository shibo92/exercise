package DesignPatterns.templatemethod;

/**
 * @author shibo
 * @date 19-12-21 下午7:03
 */
public abstract class Template {
    public abstract void doWork();

    public void doTemplateMethod(){
        System.out.println("模板方法模式");
        doWork();
    }
}
