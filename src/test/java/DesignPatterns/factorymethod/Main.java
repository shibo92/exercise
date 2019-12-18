package DesignPatterns.factorymethod;

import DesignPatterns.factorymethod.cars.Car;
import DesignPatterns.factorymethod.fatories.AudiFactory;
import DesignPatterns.factorymethod.fatories.BmwFactory;
import DesignPatterns.factorymethod.fatories.CarFactory;

/**
 * @author shibo
 * @date 19-12-18 下午5:44
 */
public class Main {
    public static void main(String[] args) {
        CarFactory audiFactory = new AudiFactory();
        Car audi = audiFactory.createCar();
        audi.drive();
        audi.stop();

        CarFactory bmwFactory = new BmwFactory();
        Car bmw = bmwFactory.createCar();
        bmw.drive();
        bmw.stop();
    }
}
