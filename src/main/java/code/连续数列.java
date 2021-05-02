package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午3:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-01 15:01
 */
public class 连续数列 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        //dp[i]是包括nums[i]的最大和
        int[] dp=new int[n];
        dp[0]=nums[0];
        int res=dp[0];
        for (int i=1;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;

    }

    @Test
    public void test()
    {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res= maxSubArray(nums);
        System.out.println(res);
    }
}
