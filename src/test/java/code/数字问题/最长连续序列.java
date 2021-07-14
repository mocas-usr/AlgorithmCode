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

        int maxLen = 0;

        //代表左右边界
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, num);
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            //只算最小的，其余的不算
            if (!map.containsKey(current-1))
            {
                //扩增窗口
                while (map.containsKey(current+1))
                {
                    current++;
                }
                //缩小窗口
                map.put(nums[i],current);
                //当前操作
                int len=current-nums[i]+1;
                if (len>maxLen)
                {
                    maxLen=len;
                }
            }

        }
        return maxLen;
    }
}
