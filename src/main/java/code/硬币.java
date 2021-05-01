package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午7:39
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 19:39
 */
public class 硬币 {
    //动态规划
    public int waysToChange(int n) {

        int[] dp = new int[n + 1];

        int[] coins = new int[]{1,5,10,25};


        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;

        /**
         * dp方程：dp[i] += dp[i - coin];
         */

        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }

        return dp[n];
    }


    @Test
    public void test()
    {
        int res=waysToChange(5);
        System.out.println(res);
    }
}
