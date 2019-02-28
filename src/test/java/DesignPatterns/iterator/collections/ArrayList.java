package DesignPatterns.iterator.collections;

import DesignPatterns.iterator.Iterator;

public class ArrayList<E> implements Collection<E> {
    Object[] items = new Object[10];
    int index = 0;

    @Override
    public void add(E o) {
        if (index == items.length) {
            // 扩容
            Object[] newItems = new Object[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
        items[index++] = o;
    }

    @Override
    public int size() {
        return this.index;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    public class ArrayListIterator implements Iterator<E> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            return (E) items[currentIndex++];
        }
    }
}
