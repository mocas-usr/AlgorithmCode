package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/16 16:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-16 16:29
 */
public class 编辑距离 {

    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        //如果其中一个是空
        if (n2*n1==0)
        {
            return n1+n2;
        }

        //dp[i][j]代表word1中的前i个字符与word2的前j个字符的步数
        int[][] dp=new int[n1+1][n2+1];

        //初始化边界
        //与空集的步数即i
        for (int i=0;i<=n1;i++)
        {
            dp[i][0]=i;
        }
        for (int j=0;j<=n2;j++)
        {
            dp[0][j]=j;
        }

        //
        for (int i=1;i<=n1;i++)
            for (int j=1;j<=n2;j++)
            {
                int ope1=dp[i-1][j-1];//如果满足，则说明只要替换最后一位就行
                int ope2=dp[i-1][j];//如果满足，只要删除word1最后一位
                int ope3=dp[i][j-1];//如果满足，只要增加最后一位
                //如果这一步不相等，则有可能有上面三步变化而来
                if (word1.charAt(i-1)!=word2.charAt(j-1))
                {
                    dp[i][j]=Math.min(ope1,Math.min(ope2,ope3))+1;
                }else //如果最后一位相等，
                {
                    dp[i][j]=dp[i-1][j-1];
                }

            }
        return dp[n1][n2];


    }

    @Test
    public void test()
    {
        String s1="horse";
        String s2="ros";
        int res=minDistance(s1,s2);
        System.out.println(res);

    }
}
