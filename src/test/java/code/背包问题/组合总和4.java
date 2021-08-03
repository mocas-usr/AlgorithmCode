package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 上午10:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-25 10:39
 */
public class 组合总和4 {
    //完全背包
    public int combinationSum4(int[] nums, int target) {


        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num:nums)
            {
                if (i>=num)
                {
                    dp[i]=dp[i]+dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
