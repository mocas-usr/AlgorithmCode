package code.前缀和;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 上午9:41
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 09:41
 */
public class 字母与数字 {

    public String[] findLongestSubarray(String[] array) {

        //代表数字比字符多处的个数
        int preSum = 0;

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = array.length;
        map.put(0, -1);
        int start = -1;
        for (int i = 0; i < n; i++) {
            //是数字
            if (Character.isDigit(array[i].charAt(0))) {
                preSum++;
            } else {
                preSum--;
            }
            if (map.containsKey(preSum)) {
                //说明存在相当情况
                int left = map.get(preSum);
                int len = i - left;//字符长度
                if (len > max) {
                    max = len;
                    start = left + 1;
                }
            } else {
                map.put(preSum, i);
            }
        }
        if (start == -1) {
            return new String[0];
        } else {
            String[] res = new String[max];
            for (int i = 0; i < max; i++) {
                res[i] = array[i + start];
            }
            return res;
        }

    }
}
