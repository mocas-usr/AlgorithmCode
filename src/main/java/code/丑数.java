package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午3:03
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 15:03
 */
public class 丑数 {
    //3指针，动态规划
    public int nthUglyNumber(int n) {
        //存储结果
        int[] dp=new int[n];
        //初始化三个指针
        int a=0;
        int b=0;
        int c=0;

        dp[0]=1;//第一个数值

        for (int i=1;i<n;i++)
        {
            int a1=dp[a]*2;
            int b1=dp[b]*3;
            int c1=dp[c]*5;
            //肯定要从这三个数值选
            dp[i]=Math.min(Math.min(a1,b1),c1);
            //
            if (dp[i]==a1)
            {
                a++;
            }
            if (dp[i]==b1)
            {
                b++;
            }
            if (dp[i]==c1)
            {
                c++;
            }

        }

        return dp[n-1];
    }
}
