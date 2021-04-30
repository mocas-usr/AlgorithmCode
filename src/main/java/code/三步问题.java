package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 上午10:49
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 10:49
 */
public class 三步问题 {
    public int waysToStep(int n) {
        if (n==1)
        {return 1;}
        if (n==2)
        {
            return 2;
        }
        //dp[i]代表第i台阶的方式
        int[] dp=new int[n+1];

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for (int i=4;i<=n;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2])%1000000007+dp[i-3];
            dp[i]%=1000000007;
        }

        return dp[n];

    }

    @Test
    public void test()
    {
        int res=waysToStep(5);
        System.out.println(res);
    }
}
