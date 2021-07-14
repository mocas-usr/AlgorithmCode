package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/15 下午9:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-15 21:23
 */
public class 不邻接植花 {

    public int[] gardenNoAdj(int n, int[][] paths) {

        //建图
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        //建立连接关系
        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boolean[] colors = new boolean[5];

            //查找相连花园颜色
            for (int t : map.get(i)) {
                //标记下不能使用
                colors[ans[t]] = true;

            }

            //染色
            for (int k = 1; k <= 4; k++) {
                if (!colors[k]) {
                    ans[i] = k;
                    break;
                }
            }

        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ans[i + 1];
        }
        return res;

    }

    @Test
    public void test() {
        int n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        int[] res = gardenNoAdj(n, paths);
        System.out.println(res);
    }
}
