package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 下午3:22
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-14 15:22
 */
public class 水域大小 {

    List<Integer> list;

    public int[] pondSizes(int[][] land) {

        list = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int temp = dfs(land, i, j);
                if (temp != 0) {
                    list.add(temp);
                }
            }
        }
        // 第二种List<Integer>转int[]，优雅且高效
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);

        return result;


    }

    //
    public int dfs(int[][] land, int i, int j) {

        int num = 0;
        //终止条件
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
            return num;
        }
        //剪枝
        if (land[i][j] != 0) {
            return num;
        }
        num++;

        //for 循环列表
        // 当前选择
        land[i][j] = -1;
        // 下一路径
        num += dfs(land, i, j + 1);
        num += dfs(land, i, j - 1);
        num += dfs(land, i - 1, j);
        num += dfs(land, i + 1, j);
        num += dfs(land, i - 1, j - 1);
        num += dfs(land, i + 1, j + 1);
        num += dfs(land, i - 1, j + 1);
        num += dfs(land, i + 1, j - 1);
        // 恢复现场
        return num;
    }
}
