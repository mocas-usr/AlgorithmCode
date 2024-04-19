package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/1 10:40
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-08-01 10:40
 */
public class 下棋棋盘 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 寻找两点之间的最短路径
     *
     * @param start int整型一维数组 起点, 数组长度2，位置0为x轴，位置1为y轴
     * @param end int整型一维数组 终点 ，数组长度2，位置0为x轴，位置1为y轴
     * @return int整型
     */
    public static int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public int findMinPath(int[] start, int[] end) {
        // write code here
        int x0 = start[0];
        int y0 = start[1];
        int x1 = end[0];
        int y1 = end[1];
        int m = grid.length;
        int n = grid[0].length;
        int max = Integer.MAX_VALUE - 1;
        int[][] path = new int[m][n];


        while (x0 != x1 && y0 != y1) {



        }

        for (int i = 1; i < m && grid[i][0] == 0; i++) {
            path[i][0] = path[i - 1][0] + 1;
        }

        for (int j = 1; j < n && grid[0][j] == 0; j++) {
            path[0][j] = path[0][j - 1] + 1;
        }
        for (int i = x1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + 1;

                }

            }
        }
        return path[m - 1][n - 1];

    }

    @Test
    public void test() {
        int[] start = {1, 1};
        int[] end = {2, 0};
        int res = findMinPath(start, end);
        System.out.println(res);
    }


}
