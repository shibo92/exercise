package DesignPatterns.proxy;

/**
 * @author shibo
 * @date 19-12-17 下午2:42
 */
public class Boy implements GiveGift {
    private Girl lover;

    public Boy(Girl lover) {
        this.lover = lover;
    }

    @Override
    public void sayHello() {
        System.out.println("real subject say hello~ to:" + lover.getName());
    }

    @Override
    public void giveFlower() {
        System.out.println("real subject give flowers~ to:" + lover.getName());
    }

    @Override
    public void giveMoney() {
        System.out.println("real subject give money~ to:" + lover.getName());
    }
}
