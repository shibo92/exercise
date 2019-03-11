package DesignPatterns.strategy;

import DesignPatterns.strategy.comparators.Comparator;

public class Dog implements Comparable{

    private int weight;
    private Comparator comparator;

    public Dog(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    /**
     * 这样实现的好处是每个类都可以有自己的比较方法
     * 缺点是：每多一种比较，就需要重新写一遍
     * 这个时候可以使用策略模式，指定该类需要使用的比较策略
     * @param obj
     * @return
     */
    /*@Override
    public int compareTo(Object obj) {
        if(obj instanceof Dog){
            Dog dog = (Dog) obj;
            if (dog.getWeight() > this.weight) {
                return 1;
            }
            if (dog.getWeight() < this.weight) {
                return -1;
            }
            return 0;
        }
        return -100;
    }*/

    @Override
    public int compareTo(Object obj) {
        return this.comparator.compareTo(this, obj);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                '}';
    }
}
