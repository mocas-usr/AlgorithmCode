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
//01背包是倒序
//完全背包是正序
//排列顺序要背包在外面,物品在里面
public class 完全平方数 {

    //完全背包问题
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i]=n;
            for (int j = 1; j *  j <= i; j++) {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];

    }

    @Test
    public void test() {

    }
}
