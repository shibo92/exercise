package leetcode;

import java.util.Arrays;

public class QuickSort {
    private static void sort(int[] a, int low, int high) {
        int i, j, index;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        index = a[j]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            // 从前向后
            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) { // // 找到比基准小的,替换之,并将低位指针后移,因为是比基准大的,不会触发下边的逻辑
                a[j] = a[i];
                j--;
            }

            // 从后向前
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i] = a[j]; // 用比基准大的记录替换高位记录
                i++;
            }
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, high); // 对高子表进行递归排序
    }

    public static void main(String[] args) {
        int[] a = {3,7,2,9,1,4,6,8,10,5};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}