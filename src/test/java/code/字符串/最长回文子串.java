package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午4:02
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-04 16:02
 */
public class 最长回文子串 {

    //动态规划
    public String longestPalindrome(String s) {

        if (s.length() == 0) {
            return "";
        }
        int n = s.length();
        //dp[i][j]代表是s[i]到s[j]是否是回文串
        boolean[][] dp = new boolean[n][n];
        char[] str = s.toCharArray();
        int len = 0;
        int max = 0;
        int start = -1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                //判断(j,i)的回文
                if (str[i] != str[j]) {
                    dp[j][i] = false;
                } else {
                    if (j - i < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                    if (dp[j][i]) {
                        len = i-j + 1;
                        if (len > max) {
                            max = len;
                            start = j;
                        }
                    }

                }

            }

        String res = s.substring(start, start + len + 1);
        return res;


    }
}
