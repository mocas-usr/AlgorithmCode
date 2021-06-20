package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午11:12
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 11:12
 */
public class 圆圈中最后剩下的数 {

    public int LastRemaining_Solution(int n, int m) {
        if (n==0)
        {
            return -1;
        }
        int f = 0;
        int[] dp = new int[n + 1];
        dp[1]=0;
        for (int i = 2; i <= n; i++) {
            dp[i]=(dp[i-1]+m)%i;
        }
        return dp[n];
    }

}
