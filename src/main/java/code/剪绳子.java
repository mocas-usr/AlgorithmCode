package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午11:03
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 11:03
 */
public class 剪绳子 {
    //动态规划
    public int cuttingRope(int n) {
     //分成两段，一段是j，绳子的长度是i
        int[] dp=new int[n+1];
        //代表绳子长度
        for (int i=2;i<=n;i++)
        {
            //代表最后一段长度
            for (int j=1;j<i;j++)
            {
                //有可能分直接相乘，也有可能
//                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];

    }

    @Test
    public void test()
    {
        cuttingRope(10);
    }
}
