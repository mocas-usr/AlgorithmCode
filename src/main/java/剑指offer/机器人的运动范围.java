package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/18 下午6:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-18 18:46
 */
public class 机器人的运动范围 {



    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visit = new boolean[rows][cols];
        int res = dfs(0, 0, threshold, rows, cols,visit);
        return res;
    }

    public int dfs(int i, int j, int count, int rows, int cols,boolean[][] visit) {
        //终止条件
        if (i < 0 || i >= rows || j < 0 || j >= cols || (i % 10 + i / 10 + j % 10 + j / 10 > count)) {
            return 0;
        }
        //剪枝
        if (visit[i][j]) {
            return 0;
        }


        visit[i][j] = true;
        int left = dfs(i + 1, j, count, rows, cols,visit);
        int right = dfs(i - 1, j, count, rows, cols,visit);

        int xia = dfs(i, j + 1, count, rows, cols,visit);
        int shang = dfs(i, j - 1, count, rows, cols,visit);

        return left + right + shang + xia + 1;
    }

    @Test
    public void test() {
        int res = movingCount(1, 3, 2);
        System.out.println(res);
    }
}
