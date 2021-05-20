package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/19 下午7:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-19 19:27
 */
public class 矩阵中战斗力最弱的k行 {

    public int[] kWeakestRows(int[][] mat, int k) {


        int t = 0;
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> list = new LinkedList<>();
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++) {
                if (list.size() == k) {
                    break;
                }
                if (mat[i][j] == 0) {
                    if (!list.contains(i)) {
                        list.add(i);
                    }


                }
            }

        int[] res = new int[k];
        while (list.size() < k) {
                for (int i=0;i<m;i++)
                {
                    if (!list.contains(i))
                    {
                        list.add(i);
                    }
                }
        }
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    @Test
    public void test() {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[] res = kWeakestRows(mat, 3);
        System.out.println(res);
    }
}
