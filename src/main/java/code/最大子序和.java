package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/20 下午3:43
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-20 15:43
 */
public class 最大子序和 {
    //动态规划
    //f(i)=max{f(i-1)+ai,ai}
    public int maxSubArray(int[] nums) {
        //假设最大子序列最后一个数是ai

        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        //求ai结尾的最大和
        for (int i=1;i<nums.length;i++)
        {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        //求出最大dp
        int maxVal=Integer.MIN_VALUE;
        for (int j=0;j<nums.length;j++)
        {
            maxVal=Math.max(maxVal,dp[j]);
        }
        return maxVal;
    }

    @Test
    public void test()
    {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res=maxSubArray(nums);
        System.out.println(res);
    }
}
