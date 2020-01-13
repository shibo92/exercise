package DesignPatterns.adapter;

/**
 * @author shibo
 * @date 19-12-17 下午2:48
 */
public class Main {
    public static void main(String[] args) {
        Chinese chineseBoy = new ChineseBoy();
        chineseBoy.sayHello();
        Chinese chineseGirl = new ChineseGirl();
        chineseGirl.sayHello();
        Chinese americanBoy = new TranslatorAdapter(new AmericanBoy());
        americanBoy.sayHello();
    }
}
