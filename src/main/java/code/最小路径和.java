package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/2 上午9:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-02 09:19
 */
public class 最小路径和 {
    //动态规划
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n=grid.length;
        int m=grid[0].length;
        //初始化
        int[][] dp=new int[n][m];
        dp[0][0]=grid[0][0];
        //如果是在第一列搜索
        for (int i=1;i<n;i++)
        {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //第一行搜索
        for (int j=1;j<m;j++)
        {
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for (int i=1;i<n;i++)
            for (int j=1;j<m;j++)
            {
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }

        return dp[n-1][m-1];


    }

    @Test
    public void test()
    {
        int[][] nums={{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(nums);
    }
}
