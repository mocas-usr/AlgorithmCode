package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/24 下午9:02
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-24 21:02
 */
public class 回旋镖的数量 {
    //
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int dis = dx * dx + dy * dy;
                map.put(dis, map.getOrDefault(dis, 0) + 1);

            }

            for (int val : map.values()) {
                res += val * (val - 1);
            }
        }
        return res;
    }
}
