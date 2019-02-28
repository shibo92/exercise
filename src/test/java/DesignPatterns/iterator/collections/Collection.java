package DesignPatterns.iterator.collections;

import DesignPatterns.iterator.Iterator;

public interface Collection<E> {
    void add(E o);

    int size();

    Iterator<E> iterator();
}
