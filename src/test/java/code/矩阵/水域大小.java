package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 下午3:59
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-14 15:59
 */
public class 水域大小 {

    boolean[][] visit;

    public int[] pondSizes(int[][] land) {

        List<Integer> list = new LinkedList<>();

        visit = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int temp = dfs(i, j, land);
                if (temp != 0) {
                    list.add(temp);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int dfs(int i, int j, int[][] land) {

        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
            return 0;
        }

        if (visit[i][j] || land[i][j] != 0) {
            return 0;
        }

        //当前选择
        visit[i][j] = true;
        int res = dfs(i - 1, j, land) + dfs(i + 1, j, land) + dfs(i, j - 1, land) + dfs(i, j + 1, land)
                + dfs(i - 1, j - 1, land) + dfs(i - 1, j + 1, land) + dfs(i + 1, j - 1, land) + dfs(i + 1, j + 1, land) + 1;
        return res;
    }

    @Test
    public void test() {

    }
}
