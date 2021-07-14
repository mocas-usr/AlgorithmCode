package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午7:50
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 19:50
 */
public class 硬币 {

    //为什么coin在外循环
    public int waysToChange(int n) {

        //dp[i]表示分法
        int[] dp = new int[n + 1];

        int[] coins = new int[]{1,5,10,25};
        dp[0]=1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;

            }
        }
        return dp[n];


    }
}
