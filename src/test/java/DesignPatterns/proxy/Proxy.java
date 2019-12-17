package DesignPatterns.proxy;

/**
 * @author shibo
 * @date 19-12-17 下午2:38
 */
public class Proxy implements GiveGift {
    private Boy boy;

    public Proxy(Girl girl) {
        this.boy = new Boy(girl);
    }

    @Override
    public void sayHello() {
        boy.sayHello();
    }

    @Override
    public void giveFlower() {
        boy.giveFlower();
    }

    @Override
    public void giveMoney() {
        boy.giveMoney();
    }

    public void proxy() {
        this.sayHello();
        this.giveFlower();
        this.giveMoney();
    }
}
