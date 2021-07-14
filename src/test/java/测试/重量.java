package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/11 下午5:12
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-11 17:12
 */
public class 重量 {
    public static int cmp(int g1, int g2, int[][] records, int n) {

        HashSet<Integer> max = new HashSet<>();
        HashSet<Integer> min = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (records[i][0] == g1) {
                min.add(records[i][1]);
            }
            if (records[i][1] == g1) {
                max.add(records[i][0]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (records[i][0] != g1 && records[i][1] != g1) {
                if (max.contains(records[i][1])) {
                    max.add(records[i][0]);
                }
                if (min.contains(records[i][0])) {
                    min.add(records[i][1]);
                }
            }
        }

        if (max.contains(g2) && !min.contains(g2)) {
            return -1;
        } else if (!max.contains(g2) && min.contains(g2)) {
            return 1;
        } else
            return 0;
    }

}
