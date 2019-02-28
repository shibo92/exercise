package DesignPatterns.iterator;

import DesignPatterns.iterator.collections.ArrayList;
import DesignPatterns.iterator.collections.Collection;
import DesignPatterns.iterator.collections.LinkedList;

public class Main {
    public static void main(String[] args) {
        Collection<User> arrayList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            User u = new User();
            u.setName("哈哈哈：" + (i + 1));
            arrayList.add(u);
        }

        Collection<User> linkedList = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            User u = new User();
            u.setName("呵呵呵：" + (i + 1));
            linkedList.add(u);
        }

        System.out.println(linkedList.size());
        Iterator<User> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            User u = iterator.next();
            System.out.println(u.toString());
        }

    }
}

class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}