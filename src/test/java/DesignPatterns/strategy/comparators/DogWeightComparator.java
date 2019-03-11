package DesignPatterns.strategy.comparators;

import DesignPatterns.strategy.Cat;
import DesignPatterns.strategy.Dog;

public class DogWeightComparator implements Comparator{

    @Override
    public int compareTo(Object o1, Object o2) {
        Dog dog1 = (Dog) o1;
        Dog dog2 = (Dog) o2;
        if (dog1.getWeight() > dog2.getWeight()) {
            return 1;
        }
        if (dog1.getWeight() < dog2.getWeight()) {
            return -1;
        }
        return 0;
    }
}
