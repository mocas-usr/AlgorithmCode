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
        if (s.length() == 0) {

            return "";
        }
        char[] str = s.toCharArray();

        int n = s.length();
        //s[i]，到s[j]是否是回文串
        boolean[][] dp = new boolean[n][n];

        int len = 1;
        int start = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str[i] != str[j]) {
                    //说明这个[j,i]不是
                    dp[j][i] = false;
                } else {
                    if (i-j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }

                if (dp[j][i] && i-j+1>len)
                {
                    len=i-j+1;
                    start=j;
                }

            }

        }
        String res=s.substring(start,start+len);
        return res;


    }

    @Test
    public void test() {
        String s = "aacabdkacaa";
        String res = longestPalindrome(s);
        System.out.println(res);

    }
}
