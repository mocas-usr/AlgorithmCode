package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/25 下午9:05
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-25 21:05
 */
public class 分糖果 {

    public int distributeCandies(int[] candyType) {

        int n = candyType.length;
        Set<Integer> set = new HashSet<>();

        for (int type : candyType) {
            set.add(type);
        }

        int num = n / 2;
        if (set.size() >= num) {
            return num;
        } else {
            return set.size();
        }

    }
}
