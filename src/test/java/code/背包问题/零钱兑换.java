package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/22 下午4:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-22 16:31
 */
/*
有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。

完全背包和01背包问题唯一不同的地方就是，每种物品有无限件。

而完全背包的物品是可以添加多次的，所以要从小到大去遍历，
在完全背包中，对于一维dp数组来说，其实两个for循环嵌套顺序同样无所谓！
*/
public class 零钱兑换 {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int max = amount + 1;

        //dp[i]代表i钱的最小硬币个数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp,1,dp.length,max);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
//        //容量
//        for (int i = 1; i <= amount; i++) {
//            //背包
//            dp[i] = max;
//            for (int j = 0; j < n; j++) {
//                if (i >= coins[j]) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
        if (dp[amount] == max) {
            return -1;
        }

        return dp[amount];

    }


    @Test
    public void test() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = coinChange(coins, amount);
        System.out.println(res);
    }
}
