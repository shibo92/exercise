package algorithm.tanxin;

/**
 * 有一楼梯共m级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？
 * @author by Administrator on 2021/3/16.
 */
public class Shangtaijie {

    public static void main(String[] args) {
        System.out.println(foo(30));
    }

    private static int foo(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n-1];
    }
}
