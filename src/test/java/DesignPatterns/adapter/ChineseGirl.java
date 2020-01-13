package DesignPatterns.adapter;

/**
 * @author shibo
 * @date 19-12-17 下午2:38
 */
public class ChineseGirl implements Chinese {

    @Override
    public void sayHello() {
        System.out.println("我不好");
    }
}
