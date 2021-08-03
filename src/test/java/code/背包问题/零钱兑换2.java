package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午8:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;


/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 20:15
 */
/*
1.如果是0-1背包，即数组中的元素不可重复使用，nums放在外循环，target在内循环，且内循环倒序；

for num in nums:
    for i in range(target, nums-1, -1):

2.如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。

for num in nums:
    for i in range(nums, target+1):

3.如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。

for i in range(1, target+1):
    for num in nums:


**/

public class 零钱兑换2 {


    public int change(int amount, int[] coins) {

        int max=amount+1;

        int n=coins.length;
        int[] dp=new int[amount+1];

        dp[0]=1;

        //
        for (int coin:coins)
        {
            for (int i=amount;i>=coin;i--)
            {
                if (i>=coin)
                {
                    dp[i]=dp[i]+dp[i-coin];

                }
            }
        }
        return dp[amount];

    }

    @Test
    public void test()
    {
        int[] coins ={1, 2, 5};
        int amount = 11;
//        int res=coinChange(coins, amount);
//        System.out.println(res);
    }
}
