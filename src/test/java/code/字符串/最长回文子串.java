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

        int len = s.length();
        char[] chars = s.toCharArray();
        //i,j代表范围内是否是回文，
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                }else {
                    if (j-i<3)
                    {
                        dp[i][j]=true;
                    }else
                    {
                        dp[i][j]=dp[i+1][j-1];
                    }

                }
                if (dp[i][j] && j-i+1>maxLen)
                {
                    begin=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
