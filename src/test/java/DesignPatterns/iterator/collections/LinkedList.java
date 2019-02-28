package DesignPatterns.iterator.collections;

import DesignPatterns.iterator.Iterator;

public class LinkedList<E> implements Collection<E> {
    Node head = null;
    Node tail = null;
    int index = 0;

    @Override
    public void add(E o) {
        Node node = new Node(o, null);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.setNext(node);
        tail = node;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<E> {
        Node lastReturn = null;
        Node next = head;
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            lastReturn = next;
            next = next.getNext();
            currentIndex++;
            return (E) lastReturn.getData();
        }
    }
}
