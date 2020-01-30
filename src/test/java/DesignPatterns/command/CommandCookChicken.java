package DesignPatterns.command;

/**
 * @author shibo
 * @date 20-1-30 上午11:08
 */
public class CommandCookChicken implements Command {
    private Receiver receiver;

    public CommandCookChicken(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.cookChicken();
    }
}
