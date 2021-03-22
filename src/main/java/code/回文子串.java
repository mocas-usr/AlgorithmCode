package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/2/17 20:44
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-02-17 20:44
 */
public class 回文子串 {
    //动态规划
    public int countSubstrings(String s) {
        // 动态规划法
        //dp[i][j]代表i,j区间是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans=0;


        for (int j=0;j< s.length();j++)
            for (int i=0;i<=j;i++)
            {
                if (s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1]))
                {
                    dp[i][j]=true;
                    ans++;
                }
            }
        return ans;

    }
}
