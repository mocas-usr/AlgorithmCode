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
public class 完全平方数 {

    public int numSquares(int n) {

        //代表n的最小数量
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i =1; i <= n; i++) {
            dp[i] = n + 1;
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
            if (dp[i] == n + 1) {
                dp[i] = 0;
            }
        }
        return dp[n];

    }
    @Test
    public void test()
    {

    }
}
