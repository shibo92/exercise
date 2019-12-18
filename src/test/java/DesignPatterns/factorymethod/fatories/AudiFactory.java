package DesignPatterns.factorymethod.fatories;

import DesignPatterns.factorymethod.cars.Audi;
import DesignPatterns.factorymethod.cars.BMW;
import DesignPatterns.factorymethod.cars.Car;

/**
 * @author shibo
 * @date 19-12-18 下午5:43
 */
public class AudiFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Audi();
    }
}
