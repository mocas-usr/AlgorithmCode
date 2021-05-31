package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/21 上午10:22
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-21 10:22
 */
public class 最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[i][j]表示text1 i长度的前缀和text2 j长度前缀的公共字符串
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <=m; i++) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = text2.charAt(j - 1);
                //
                if (a == b) {
                    //dp[i-1][j-1]代表出去a,b的字符串
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }

        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String text1 = "abcde";
        String text2= "ace";
        int res=longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
}
