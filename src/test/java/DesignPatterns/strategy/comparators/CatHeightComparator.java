package DesignPatterns.strategy.comparators;

import DesignPatterns.strategy.Cat;

public class CatHeightComparator implements Comparator{

    @Override
    public int compareTo(Object o1, Object o2) {
        Cat cat1 = (Cat) o1;
        Cat cat2 = (Cat) o2;
        if (cat1.getHeight() > cat2.getHeight()) {
            return 1;
        }
        if (cat1.getHeight() < cat2.getHeight()) {
            return -1;
        }
        return 0;
    }
}
