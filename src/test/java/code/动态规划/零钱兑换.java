package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午7:54
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 19:54
 */
public class 零钱兑换 {

    public int coinChange(int[] coins, int amount) {


        //代表最小数量
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE-1;
            for (int j = coins.length - 1; j >= 0; j--) {
                int coin = coins[j];
                if (i-coin>=0)
                {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

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
        int res=coinChange(coins,amount);
        System.out.println(res);
    }

}
