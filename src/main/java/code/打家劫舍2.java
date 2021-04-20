package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/14 上午9:45
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-14 09:45
 */
public class 打家劫舍2 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        //dp[i]代表前i个数中最大的值
        //不抢最后一个
        int res=0;
        int len = nums.length;
        int[] dp1 = new int[nums.length];
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0],nums[1]);

        for (int i=2;i<len-1;i++)
        {
         dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);

        }
        res=dp1[len-2];
        //不抢第一个
        int[] dp2 = new int[nums.length];
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1],nums[2]);

        for (int i=3;i<nums.length;i++)
        {
            dp2[i]=Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }

        return Math.max(res,dp2[len-1]);


    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        int res = rob(nums);
        System.out.println(res);
    }
}
