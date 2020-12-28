package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/21 下午8:47
 * @email: wangyuhang_mocas@163.com
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-21 20:47
 */
public class 两数之和 {

    //哈希表
    public int[] twoSum(int[] nums, int target) {
        //记录数值与位置
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<nums.length;i++)
        {

            int t=target-nums[i];//组成和的数值
            if (map.containsKey(t))
            {
                return new int[]{i,map.get(t)};
            }
            //将数值放入
            map.put(nums[i],i);
        }
        //如果没有则返回空
        return new int[2];

    }
}
