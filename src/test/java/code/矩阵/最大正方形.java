package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/24 下午8:28
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-24 20:28
 */
public class 最大正方形 {

    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        //以坐标[i,j]右下角的正方形边长
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]))+1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }

        return maxSide * maxSide;
    }

}
