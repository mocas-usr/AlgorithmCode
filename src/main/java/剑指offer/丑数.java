package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午8:02
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 20:02
 */
public class 丑数 {

    //动态规划+队列
    public int GetUglyNumber_Solution(int index) {
        if (index==0)
        {
            return 0;
        }
        int a2 = 0, a3 = 0, a5 = 0;

        int[] dp = new int[index];
        dp[0] = 1;

        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(dp[a5] * 5, Math.min(dp[a2] * 2, dp[a3] * 3));
            if (dp[i] == dp[a5] * 5) {
                //指针移动
                a5++;
            }
            if (dp[i] == dp[a2] * 2) {
                a2++;
            }
            if (dp[i] == dp[a3] * 3) {
                a3++;
            }
        }
        return dp[index-1];
    }


}
