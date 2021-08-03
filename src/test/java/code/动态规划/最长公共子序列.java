package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 上午11:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-25 11:39
 */
public class 最长公共子序列 {


    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        //说明text1前i个字符串与text2前i个字符串的相同个数
        int[][] dp = new int[n1 + 1][n2 + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= n1; i++) {
            char ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                }
            }

        }
        return dp[n1][n2];
    }
}
