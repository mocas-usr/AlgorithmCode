package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/9 下午8:36
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-09 20:36
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {

        //先求前缀和

        int n = nums.length;
        int[] dp = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = sum;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int numSum : dp) {
            int num = map.getOrDefault(numSum - k, 0);
            res += num;
            map.put(numSum, map.getOrDefault(numSum, 0) + 1);

        }
        return res;


    }

    @Test
    public void test() {

        int[] nums = {1, 1, 1};
        int k = 2;
        int res=subarraySum(nums, k);
        System.out.println(res);
    }
}
