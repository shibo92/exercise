package algorithm.tanxin;

import java.util.Arrays;

/**
 * @author by Administrator on 2021/3/16.
 */
public class MergeShuzu {
    public static void main(String[] args) {
        merge(new int[]{1,2,4,5,7,0,0,0,0},5,new int[]{3,8},2);
    }
    public static void merge(int A[], int m, int B[], int n) {
        int p1=m-1,p2=n-1,i=m+n-1;
        while (p1>=0 && p2>=0){
            A[i--]= A[p1]>B[p2]?A[p1--]:B[p2--];
        }
        while (p2>=0){
            A[i--] = B[p2--];
        }

        for (int i1 : A) {
            System.out.print(i1 + " ");
        }
    }
}
