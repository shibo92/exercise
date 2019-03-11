package DesignPatterns.strategy;

import DesignPatterns.strategy.comparators.CatHeightComparator;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(10);
        Cat cat2 = new Cat(20);
        Cat cat3 = new Cat(3);

        cat1.setComparator(new CatHeightComparator());
        cat2.setComparator(new CatHeightComparator());
        cat3.setComparator(new CatHeightComparator());

        Cat[] arr = new Cat[]{cat1,cat2,cat3};
        Collections.sort(arr);
        Collections.print(arr);
/*
        Dog[] arr2 = new Dog[]{new Dog(10),new Dog(20),new Dog(3)};
        Collections.sort(arr2);
        Collections.print(arr2);*/
    }
}
