package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/27 下午9:03
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-27 21:03
 */
public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {

        //map记录的是以k为起点的最长
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            //默认自身长度
            map.put(num, num);
        }

        int res = 0;
        for (int num : nums) {
            int current = num;

            while (map.containsKey(current + 1)) {
                current++;
            }
            //num为起点，current为终点
            map.put(num, current);
            int len = current - num + 1;
            res = Math.max(len, res);
        }
        return res;
    }
}
