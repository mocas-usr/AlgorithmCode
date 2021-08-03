package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/2 下午10:21
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-08-02 22:21
 */
public class 最长递增子序列 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        //代表以nums[i]结尾的长度
        int[] dp = new int[n + 1];

        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
            res = Math.max(res, dp[i]);

        }
        return res;


    }

    @Test
    public void test()
    {
        int[] nums={
                10,9,2,5,3,7,101,18
        };
        int res=lengthOfLIS( nums);
        System.out.println(res);
    }
}
