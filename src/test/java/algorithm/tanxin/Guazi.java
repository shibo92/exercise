package algorithm.tanxin;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by Administrator on 2021/8/10.
 */
public class Guazi {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int[] res = foo(nums);
    }
    static int[] foo(int[] nums){
        if(null == nums) return null;
        List<Integer> resList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1] - 1 != nums[i]){
                resList.add(nums[i]);
                resList.add(nums[i]+1);
                // nums[i+1] = nums[i] + 1;
                break;
            }
        }
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }
}
