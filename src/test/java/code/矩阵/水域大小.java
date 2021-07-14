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

    public int[] pondSizes(int[][] land) {

        List<Integer> list = new LinkedList<>();

        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int temp = dfs(land, i, j, 0);
                if (temp != 0) {
                    list.add(temp);
                }
            }

        int[] res = new int[list.size()];
        for (int i=0;i<res.length;i++)
        {
            res[i]=list.get(i);
        }
        Arrays.sort(res);
        return res;

    }

    public int dfs(int[][] land, int i, int j, int sum) {
        //终止条件
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
            return 0;
        }
        //剪枝
        if (land[i][j] !=0) {
            return 0;
        }

        //当前操作
        land[i][j] = -1;
        sum++;
        return dfs(land, i - 1, j, sum) + dfs(land, i, j + 1, sum) + dfs(land, i + 1, j, sum) + dfs(land, i, j - 1, sum)
                + dfs(land, i - 1, j-1, sum)+ dfs(land, i - 1, j+1, sum)+ dfs(land, i +1, j-1, sum)+ dfs(land, i +1, j+1, sum)+ 1;
    }

    @Test
    public void test()
    {

    }
}
