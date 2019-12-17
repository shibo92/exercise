package DesignPatterns.decorator.decorators;

import DesignPatterns.decorator.components.Beverage;

/**
 * 具体的装饰子类，在商品基础上装饰其他内容
 * @author shibo
 * @date 19-12-17 上午9:57
 */
public class IceDecorator extends Decorator {

    public IceDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public void mixed() {
        super.mixed();
        System.out.println("加冰");
    }
    @Override
    public Double cost(){
        return 1.00 + super.cost();
    }
}
