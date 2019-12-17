package DesignPatterns.decorator;

import DesignPatterns.decorator.components.Beverage;
import DesignPatterns.decorator.components.Coke;
import DesignPatterns.decorator.decorators.IceDecorator;
import DesignPatterns.decorator.decorators.SugarDecorator;

import java.io.*;

/**
 * 装饰者模式将商品类和装饰类抽象出来，降低耦合性
 * 同时多个装饰类可以相互依赖
 * @author shibo
 * @date 19-12-17 上午9:45
 */
public class Person {
    public static void main(String[] args) throws FileNotFoundException {
        Beverage coke = new Coke();
        IceDecorator ice = new IceDecorator(coke);
        SugarDecorator sugar = new SugarDecorator(ice);
        sugar.mixed();
        System.out.println(sugar.cost().toString());
    }
}
