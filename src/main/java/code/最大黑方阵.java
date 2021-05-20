package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/18 下午7:39
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-18 19:39
 */
public class 最大黑方阵 {
    public int[] findSquare(int[][] grid) {
        int n = grid.length;
        //dp[i][j][0]: i,j左边连续的0的个数
        //dp[i][j][1]: i,j上边连续的0的个数
        int[][][] dp = new int[n][n][2];
        int size = 0; // "最大黑方阵"的边长
        int r = -1, c = -1; // "最大黑方阵"左上角的行号和列号
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j][0] = 1 + (j > 0 ? dp[i][j - 1][0] : 0);
                    dp[i][j][1] = 1 + (i > 0 ? dp[i - 1][j][1] : 0);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 枚举以[i,j]为右下角的正方形的可能边长side
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--) {
                    if (dp[i][j - side + 1][1] >= side && dp[i - side + 1][j][0] >= side) {
                        if (side > size) {
                            size = side;
                            r = i - side + 1;
                            c = j - side + 1;
                            break; // 更短的就没必要考虑了
                        }
                    }
                }
            }
        }
        if (r == -1 && c == -1)
            return new int[0];
        else
            return new int[]{r, c, size};
    }

    @Test
    public void test() {
        int[][] grid = {{1, 0, 1}, {0, 0, 1}, {0, 0, 1}};
        int[] res = findSquare(grid);
        System.out.println(res);
    }
}
