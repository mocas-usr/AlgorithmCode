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

        //k,v代表当前左右边界
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            //初始化左右边界
            map.put(num, num);
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            int current=nums[i];

            while (map.containsKey(current+1))
            {
                current++;
            }

            map.put(nums[i],current);
            res=Math.max(res,current-nums[i]+1);
        }

        return res;
    }
}
