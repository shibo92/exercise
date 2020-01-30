package DesignPatterns.command;

/**
 * 服务员
 * @author shibo
 * @date 20-1-30 上午11:15
 */
public class Invoker {
    Command command;

    // 设置命令
    public void setCommand(Command command){
        this.command = command;
    }
    // 通知厨子做饭
    public void notifyCooker(){
        System.out.println("服务员已下单");
        command.execute();
    }
}
