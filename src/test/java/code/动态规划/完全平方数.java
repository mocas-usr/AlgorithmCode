package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午8:09
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 20:09
 */
public class 完全平方数 {

    public int numSquares(int n) {

        //dp[i]代表n需要的最小平方个数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = n+1;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }


        return dp[n];
    }

    @Test
    public void test() {
        int res = numSquares(2);
        System.out.println(res);
    }
}
