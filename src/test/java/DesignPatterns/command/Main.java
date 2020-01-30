package DesignPatterns.command;

/**
 * @author shibo
 * @date 20-1-30 上午11:17
 */
public class Main {
    public static void main(String[] args) {
        Receiver cooker = new Receiver();
        Command cookChicken = new CommandCookChicken(cooker);
        Command cookCake = new CommandCookCake(cooker);
        Invoker invoker = new Invoker();
        invoker.setCommand(cookChicken);
        invoker.notifyCooker();
        invoker.setCommand(cookCake);
        invoker.notifyCooker();
    }
}
