package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/11 16:09
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-11 16:09
 */
public class 母牛生产 {
    public int countSum(int n) {
        // write code here

        int mod=1000000007;
        //dp[i] i年生的
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=2;
        dp[2]=3;
        //增加量s[i]代表第i年增加量
        //dp[i]=dp[i-1]+s[i]
        int[] s=new int[n+1];
        s[0]=1;
        s[1]=1;
        s[2]=1;
        for (int i=3;i<n;i++)
        {
            s[i]=dp[i-1]-s[i-1]-s[i-2];
            dp[i]=(dp[i-1]+s[i])%mod;

        }
        return dp[n-1];

    }

    @Test
    public void test()
    {
        int res=countSum(6);
        System.out.println(res);
    }
}
