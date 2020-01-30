package DesignPatterns.command;

/**
 * @author shibo
 * @date 20-1-30 上午11:07
 */
public class Receiver {
    public void cookChicken() {
        System.out.println("厨子开始做鸡翅");
    }

    public void cookCake() {
        System.out.println("厨子开始做蛋糕");
    }
}
