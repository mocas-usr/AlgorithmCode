package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/17 下午8:22
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-17 20:22
 */
public class 买卖股票的最佳时机 {
    //最大利润
    public int maxProfit(int[] prices) {

        if (prices.length<=1)
        {
            return 0;
        }
        int maxprofit=0;
        int profit=0;

        //先定买股票的时机
        int buy=prices[0];
        //从第二个日期开始
        for (int i=1;i<prices.length;i++)
        {
            //如果当天的利润小
            if (buy>prices[i])
            {
                buy=prices[i];
            }else if (buy<=prices[i])
            {
                profit=prices[i]-buy;
                //此时考虑卖出
                maxprofit=Math.max(maxprofit,profit);

            }

        }
        return maxprofit;
    }
}
