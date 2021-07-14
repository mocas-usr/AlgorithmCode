package 企业题库;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/5 下午3:58
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-05 15:58
 */
public class H最小值 {

    public int minPathSum(int[][] grid) {
        int res=Integer.MAX_VALUE;
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
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                res=Math.min(res,dp[i][j]);
            }

        return res;


    }

    @Test
    public void test()
    {
        int[][] grid={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int res=minPathSum(grid);
        System.out.println(res);
    }
}
