package DesignPatterns.decorator.decorators;

import DesignPatterns.decorator.components.Beverage;

/**
 * 装饰抽象类
 * 主要作用是持有被装饰类和调用被装饰类的方法
 * @author shibo
 * @date 19-12-17 上午9:52
 */
abstract class Decorator extends Beverage {
    private Beverage beverage; // 持有一个被装饰类

    public Decorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void mixed() {
        // 执行被装饰类方法
        beverage.mixed();
    }

    @Override
    public Double cost() {
        // 执行被装饰类方法
        return beverage.cost();
    }
}
