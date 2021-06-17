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
//        if (paths.length<1)
//        {
//            return new int[0];
//        }
        //建立邻接关系
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            map.get(path[0] - 1).add(path[1] - 1);
            map.get(path[1] - 1).add(path[0] - 1);
        }


        int[] answer = new int[n];
        //花园遍历
        for (int i = 0; i < n; i++) {
            //周围花的种类
            //花园颜色
            boolean[] colors = new boolean[5];

            for (int t : map.get(i))//adj[i]是包含了与i邻接的花园linklist
            {
                //邻接花园颜色设为true，
                colors[answer[t]] = true;
            }

            //寻找花色
            for (int k = 1; k < 5; k++) {
                if (!colors[k]) {
                    answer[i] = k;
                    break;
                }
            }

        }

        return answer;

    }

    @Test
    public void test() {
        int n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        int[] res = gardenNoAdj(n, paths);
        System.out.println(res);
    }
}
