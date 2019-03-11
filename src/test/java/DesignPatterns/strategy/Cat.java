package DesignPatterns.strategy;

import DesignPatterns.strategy.comparators.Comparator;

public class Cat implements Comparable {

    private int height;
    private Comparator comparator;

    public Cat(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    /**
     * 这样实现的好处是每个类都可以有自己的比较方法
     * 缺点是：每多一种比较，就需要重新写一遍
     * 这个时候可以使用策略模式，指定该类需要使用的比较策略
     *
     * @param obj
     * @return
     */

    /* @Override
    public int compareTo(Object obj) {
        if(obj instanceof Cat){
            Cat cat = (Cat) obj;
            if (cat.getHeight() > this.height) {
                return 1;
            }
            if (cat.getHeight() < this.height) {
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
        return "Cat{" +
                "height=" + height +
                '}';
    }
}
