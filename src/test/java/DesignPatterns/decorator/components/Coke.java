package DesignPatterns.decorator.components;

/**
 * 具体商品-可乐
 * @author shibo
 * @date 19-12-17 上午9:49
 */
public class Coke extends Beverage {
    @Override
    public void mixed() {
        System.out.println("购买可乐..");
    }

    @Override
    public Double cost() {
        return 3.00;
    }
}
