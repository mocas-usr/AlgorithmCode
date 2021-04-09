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
        int[][] path = new int[m][n];
        path[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            path[0][j] = path[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j]=Math.min(path[i-1][j],path[i][j-1])+grid[i][j];

            }
        }
        return path[m-1][n-1];

    }
}
