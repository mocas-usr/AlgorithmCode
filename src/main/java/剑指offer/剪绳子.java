package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/18 下午7:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-18 19:23
 */
public class 剪绳子 {

    //动态规划
    public int cutRope(int target) {

        if (target == 2) {
            return 2;
        }
        if (target == 3) {
            return 2;
        }

        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 4;

        for (int i = 5; i < target + 1; i++)
            for (int j = 1; j < i; j++) {
//                dp[i] = ;
                dp[i]=Math.max(dp[i],Math.max(dp[i - j] * j, (i - j) * j));
            }
        return dp[target];
    }

    @Test
    public void test()
    {

    }
}
