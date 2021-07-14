package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 下午4:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-13 16:17
 */
public class 最大子序和 {
    //动态规划
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        //表示包含nums[i]的最大数值
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i=1;i<n;i++)
        {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;

    }

    @Test
    public void test() {
        String a = "";
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{1, 2};
        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));

    }
}
