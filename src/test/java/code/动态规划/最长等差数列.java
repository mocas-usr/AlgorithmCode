package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/14 上午10:03
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-14 10:03
 */
public class 最长等差数列 {

    public int longestArithSeqLength(int[] nums) {

        //dp[i][j]代表截止到nums[i]，等差为j的最长数列数值
        int[][] dp = new int[nums.length][20001];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 20001; j++) {
                //初始化本身就是数组为1
                dp[i][j] = 1;
            }
        }

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j]+10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                res = Math.max(res, dp[i][diff]);
            }
        }
        return res;

    }
}
