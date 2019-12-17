package DesignPatterns.decorator.components;

/**
 * 具体商品-牛奶
 * @author shibo
 * @date 19-12-17 上午9:49
 */
public class Milk extends Beverage {
    @Override
    public void mixed() {
        System.out.println("购买牛奶..");
    }

    @Override
    public Double cost() {
        return 5.00;
    }
}
