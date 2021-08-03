package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/17 20:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

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

        if (nums.length==0)
        {
            return 0;
        }
        //左右代表连续序列的左右边界
        Map<Integer, Integer> map = new HashMap<>();


        for (int num:nums)
        {
            map.put(num,num);
        }
        int res=1;

        for (int i = 0; i < nums.length; i++) {

            int current=nums[i];
            //从最小的那个数开始计算
            if (!map.containsKey(current-1))
            {
                //扩增窗口
                while (map.containsKey(current+1))
                {
                    current++;
                }
            }

            //缩减窗口
            map.put(nums[i],current);
            res=Math.max(res,current-nums[i]+1);
        }
        return res;

    }

    @Test
    public void test()
    {
        int[] nums ={100,4,200,1,3,2};
        int res=longestConsecutive(nums);
        System.out.println(res);

    }
}
