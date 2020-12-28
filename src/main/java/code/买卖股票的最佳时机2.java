package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/17 下午8:47
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-17 20:47
 */
public class 买卖股票的最佳时机2 {

    //动态规划
    public int maxProfit(int[] prices) {

        //
        int n=prices.length;
        int[][] dp=new int[n][2];
        //dp[0][0]代表持有现金，而不是股票
        dp[0][0]=0;
        //代表持有股票，而不是现金
        dp[0][1]=-prices[0];

        for (int i=1;i<n;i++)
        {
            //持有现金，有可能是前一天持有不变，也有可能昨天还是持有，今天卖了
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        //最后一天是卖出的，换成现金
        return dp[n-1][0];
    }


    //贪心求和
    public int maxProfit2(int[] prices)
    {

        int len=prices.length;
        if (len<2)
        {
            return 0;
        }
        int profit=0;
        for (int i=1;i<len;i++)
        {
            //如果相对前一天上升就相加，
            profit+=Math.max(0,prices[i]-prices[i-1]);
        }

        return profit;
    }

    @Test
    public void test()
    {
        int[] prices={7,6,4,3,1};
        maxProfit(prices);
    }
}
