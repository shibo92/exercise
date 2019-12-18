package DesignPatterns.factorymethod.cars;

/**
 * @author shibo
 * @date 19-12-18 下午5:41
 */
public class BMW implements Car {
    private final String name = "BMW";

    @Override
    public void drive() {
        System.out.println(name + "is running...");
    }

    @Override
    public void stop() {
        System.out.println(name + "is stop...");
    }
}
