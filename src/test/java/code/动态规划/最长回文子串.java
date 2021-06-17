package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/3/30 下午3:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-03-30 15:29
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //dp[i][j]代表i,j范围是否为回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 0;
        String res = s.substring(0, 1);
        char[] str = s.toCharArray();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str[j] != str[i]) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    res = s.substring(j, j + maxLen);
                }
            }


        }
        return res;


    }

    @Test
    public void test() {
        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);

    }
}
