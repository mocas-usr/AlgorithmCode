package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午4:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

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

        char[] str = s.toCharArray();

        int n = s.length();
        int maxLen=1;
        int start=0;
        //dp[i][j]代表s[i]到s[j]是否是回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (str[i] == str[j]) {

                    if (i-j<3)
                    {
                        dp[i][j]=true;
                    }else
                    {
                        dp[i][j]=dp[i-1][j+1];
                    }


                } else {
                    dp[j][i] = false;
                }

                if (dp[i][j] &&i-j+1>maxLen)
                {
                    start=j;
                    maxLen=Math.max(maxLen,i-j+1);
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    @Test
    public void test()
    {
        String res=longestPalindrome("ccc");
        System.out.println(res);
    }
}
