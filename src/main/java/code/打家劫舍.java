package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/18 21:52
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-18 21:52
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        if(nums.length==0 )
        {
            return 0;
        }
        if(nums.length<2)return nums[0];
        //dp[i]代表前i个数中最大的值
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for (int i=2;i<nums.length;i++)
        {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];

    }
}
