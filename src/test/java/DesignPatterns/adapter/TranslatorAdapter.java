package DesignPatterns.adapter;

/**
 * @author shibo
 * @date 19-12-17 下午2:38
 */
public class TranslatorAdapter implements Chinese {
    AmericanBoy americanBoy;

    public TranslatorAdapter(AmericanBoy americanBoy) {
        this.americanBoy = americanBoy;
    }

    @Override
    public void sayHello() {
        this.translate(americanBoy.sayHello());
    }

    private void translate(String sayHello) {
        if("hello".equals(sayHello)){
            System.out.println("american say 你好");
        }
    }
}
