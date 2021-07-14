package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午8:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 20:15
 */
public class 零钱兑换2 {
    public int coinChange(int[] coins, int amount) {

        //代表最少硬币个数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        //不要求硬币的顺序摆放,外循环是amount
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length ; j++) {
                dp[i]=Integer.MAX_VALUE-1;
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        if (dp[amount]>=Integer.MAX_VALUE-1)
        {
            return -1;
        }
        return dp[amount];

    }

    @Test
    public void test()
    {
        int[] coins ={1, 2, 5};
        int amount = 11;
        int res=coinChange(coins, amount);
        System.out.println(res);
    }
}
