package DesignPatterns.command;

/**
 * @author shibo
 * @date 20-1-30 上午11:08
 */
public class CommandCookCake implements Command {
    private Receiver receiver;

    public CommandCookCake(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.cookCake();
    }
}
