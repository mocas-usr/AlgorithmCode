package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 下午3:30
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-13 15:30
 */
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length<2)
        {
            return 0;
        }
        //记录波动矩阵
        int[] diff=new int[prices.length-1];

        for (int i=0;i<prices.length-1;i++)
        {
            //第i-i+1天的波动
            diff[i]=prices[i+1]-prices[i];
        }

        //动态规划，第index天的利润最大
        int[] dp=new int[diff.length];

        //以i天抛出的股票最大利润
        dp[0]=diff[0];
        int index=0;
        int profit=0;
        profit=Math.max(dp[0],profit);
        for (int i=1;i<diff.length;i++)
        {
            dp[i]=Math.max(dp[i-1]+diff[i],diff[i]);
            profit=Math.max(dp[i],profit);
        }

        return profit;


    }

    //最大最小直接比较
    public int maxProfit2(int[] prices)
    {
        if (prices.length<2)
        {
            return 0;
        }
        int profit=0;//；利润
        int buy=prices[0];//购买价格
        for (int i=0;i<prices.length;i++)
        {
            //如果现在的价格小于原先购买价格，则现在购买
            if(buy>=prices[i])//buy是股票最小值
            {
                buy=prices[i];
            }else //buy<price,考虑抛出
            {
                //抛出最大值比较
                profit=Math.max(profit,prices[i]-buy);
            }
        }
        return profit;
    }

    @Test
    public void test()
    {
        int[] nums={1,2};
        maxProfit(nums);
    }
}
