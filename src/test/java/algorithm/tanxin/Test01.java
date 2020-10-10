package algorithm.tanxin;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by shibo on 2020/9/22.
 * 贪心算法-最大装载问题
 * 问题描述：某艘船的载重量为C，每件物品的重量为wi,要将尽量多的物品装入到船上。
 */
public class Test01 {
    @Test
    public void test() {
        // 对应物品重量
        Integer[] wi = new Integer[]{9, 2, 4, 1, 6, 8, 7};
        int c = 20;
        // 总重量
        int tmp = 0;
        // 总件数
        // int sum = wi.length;
        int sum = 0;
        Arrays.sort(wi);
        for (Integer integer : wi) {
            System.out.print(integer + " ");
        }

        for (int i = 0; i < wi.length; i++) {
            tmp += wi[i];
            if (tmp <= c) {
                sum++;
            } else {
                tmp-=wi[i];
                break;
            }
        }
        System.out.println("一共可以拉 " + sum + "件物品，总重量:" + tmp);
    }

    // 优化
    @Test
    public void Test2() {
        // 对应物品重量
        Integer[] wi = new Integer[]{9, 2, 4, 1, 6, 8, 7};
        int c = 20;
        // 总重量
        int tmp = 0;
        // 总件数
        int sum = wi.length;
        Arrays.sort(wi);
        for (Integer integer : wi) {
            System.out.print(integer + " ");
        }

        for (int i = 0; i < wi.length; i++) {
            tmp += wi[i];
            // 用大于判断可以减少运算
            if (tmp >= c) {
                if(tmp == c){
                    sum = i + 1; // 最后一件可以放进去
                } else{
                    sum = i;
                    tmp -= wi[i];
                }
                break;
            }
        }
        System.out.println("一共可以拉 " + sum + "件物品，总重量:" + tmp);
    }
}