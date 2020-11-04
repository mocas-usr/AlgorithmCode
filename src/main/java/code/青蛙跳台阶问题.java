package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午3:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 15:25
 */
public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        if (n==0)
        {
            return 1;
        }
        int[] dp=new int[n+1];//动态规划
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<n+1;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];

    }
}
