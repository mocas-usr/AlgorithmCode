package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/7 21:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-07 21:39
 */
public class 最小路径和 {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        //grid[i][j]代表到达(i,j)坐标的最小和
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //
        for (int i = 1; i < m; i++) {

            dp[i][0] = dp[i - 1][0] + grid[i][0];

        }

        for (int j = 1; j < n; j++) {

            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }

        return dp[m - 1][n - 1];


    }
}
