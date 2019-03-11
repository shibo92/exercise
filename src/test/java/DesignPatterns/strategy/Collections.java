package DesignPatterns.strategy;

import java.util.Arrays;

public class Collections {
    public static void sort(Object[] objects){
        for (int i = 0; i < objects.length - 1; i++) {
            for (int j = 0; j < objects.length -1 ; j++) {
                Comparable o1 = (Comparable) objects[j];
                Comparable o2 = (Comparable) objects[j+1];
                if (o1.compareTo(o2) > 0) {
                    swap(objects, j);
                }
            }
        }
    }
    private static void swap(Object[] a, int j) {
        Object tmp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = tmp;
    }

    public static void print(Object[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
