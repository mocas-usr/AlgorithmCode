package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 下午3:53
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 15:53
 */
public class 按摩师 {

    public int massage(int[] nums) {
        if (nums.length==0)
        {
            return 0;
        }

        int m = nums.length;
        //dp[i]代表0到第i个数的最长预约时间
        int[] dp = new int[m + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= m; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[m];

    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        int res = massage(nums);
        System.out.println(res);
    }
}
