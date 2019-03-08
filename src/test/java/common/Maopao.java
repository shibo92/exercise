package common;

import java.util.ArrayList;
import java.util.List;

public class Maopao {
    public static void main(String[] args) {
        int a[] = {2, 6, 1, 3, 8};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length -1 ; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j);
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        List<String>[] d = new ArrayList[10];
    }

    private static void swap(int[] a, int j) {
        int tmp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = tmp;
    }

}