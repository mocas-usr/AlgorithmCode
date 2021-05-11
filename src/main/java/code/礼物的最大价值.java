package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午4:06
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-08 16:06
 */
public class 礼物的最大价值 {

    public int maxValue(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i=1;i<m;i++)
        {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for (int i=1;i<n;i++)
        {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for (int i=1;i<m;i++)
        {
            for (int j=1;j<n;j++)
            {
               dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }
}
