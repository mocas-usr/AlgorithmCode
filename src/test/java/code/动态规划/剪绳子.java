package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 下午3:13
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-07 15:13
 */
public class 剪绳子 {
    public int cuttingRope(int n) {

        if (n==2)
        {
            return 1;
        }
        if (n==3)
        {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;
        dp[4]=4;
        for (int i = 5; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }

        }
        return dp[n];

    }


    @Test
    public void test() {
        int res = cuttingRope(6);
        System.out.println(res);
    }
}
