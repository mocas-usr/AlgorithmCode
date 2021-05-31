package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/24 下午8:21
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-24 20:21
 */
public class 统计全为1的正方形子矩阵 {
    //正方形
    public int countSquares(int[][] matrix) {
        //特殊值排除
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int side = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //dp[i][j]表示i,j为右下角的正方形的边长
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                    }
                }


                res += dp[i][j];
            }

        return res;
    }
}
