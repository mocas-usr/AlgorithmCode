package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/17 20:46
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-17 20:46
 */
public class 最长连续序列 {
    //哈希表
    public int longestConsecutive(int[] nums) {

        //k,v代表当前左右边界,代表滑动窗口的左右数值
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            //初始化左右边界为自身数值
            map.put(num, num);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //扩增窗口大小
            int num = nums[i];
            while (map.containsKey(num + 1)) {
                num++;
            }
            //缩减窗口
            //当前操作
            map.put(nums[i], num);
            res = Math.max(res, num - nums[i] + 1);
        }
        return res;


    }
}
