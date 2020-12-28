package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 下午4:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-13 16:17
 */
public class 最大子序和 {
    //动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length==0)
        {
            return 0;
        }
        //长度
        int len=nums.length;
        //dp
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int maxRes=dp[0];
        for (int i=1;i<len;i++)
        {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            maxRes=Math.max(maxRes,dp[i]);
        }

        return maxRes;


    }
    @Test
    public void test()
    {
        String a="";
        int[] arr1=new int[]{1,2};
        int[] arr2=new int[]{1,2};
        System.out.println(arr1==arr2);
        System.out.println(arr1.equals(arr2));

    }
}
