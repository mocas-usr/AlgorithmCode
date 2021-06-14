package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/13 下午9:47
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-13 21:47
 */
public class 最长等差数列 {

    public int longestArithSeqLength(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        //dp[i][j]代表以nums[i]结尾，j为公差的最长等差个数
        int[][] dp = new int[n][20002];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 1;
            }
        }


        int res=1;
        for (int i = 0; i < n; i++) {
            for (int j=i-1;j>=0;j--)
            {
                int diff=nums[i]-nums[j]+10000;
                dp[i][diff]=Math.max(dp[i][diff],dp[j][diff]+1);

                res=Math.max(res,dp[i][diff]);


            }
        }
        return res;

    }

    @Test
    public void test() {
        int[] nums = {9, 4, 7, 2, 10};
        int res = longestArithSeqLength(nums);
        System.out.println(res);
    }
}
