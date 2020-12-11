package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 下午8:35
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-09 20:35
 */
public class 连续子数组的最大和 {

    //动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length==0)
        {
            return 0;
        }
        int len=nums.length;
        //dp[i]代表以numsi结尾的数值最大值
        int[] dp=new int[len];
        int res=nums[0];
        dp[0]=nums[0];
        for (int  i=1;i<len;i++)
        {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
