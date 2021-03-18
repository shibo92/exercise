package algorithm.tanxin;

/**
 *  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233……
 * 斐波那契数列 动态规划实现
 * @author by Administrator on 2021/3/16.
 *
 */
public class Feibonaqi {
    public static void main(String[] args) {
        System.out.println(foo(46));
        System.out.println(foo(47));
        System.out.println(foo(48));
        System.out.println(foo(49));
    }
    public static long foo(int n){
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            if(i<2){
                result[i] = i;
            }else{
                result[i] = result[i-1] + result[i-2];
            }
        }
        return result[n-1];
    }
}
