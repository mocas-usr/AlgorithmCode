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
    public int cuttingRope2(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        //表示n长的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;

        for (int i = 5; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j], i - j) * j, dp[i]);
            }
        }
        return dp[n];

    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int t = n / 3 - 1;
        int sh = n % 3;
        //求3的t次方
        int res = (int) Math.pow(3, t);
        if (sh == 0) {
            return res * 3;
        } else if (sh == 1) {
            return res * 4;
        } else {
            return res * 6;
        }

    }

    @Test
    public void test() {
        int res = cuttingRope(6);
        System.out.println(res);
    }
}
