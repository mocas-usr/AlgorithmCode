package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/22 下午5:14
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-22 17:14
 */
public class 扑克牌中的顺子 {

    //排序做法
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joke=0;
        //遍历五张牌
        for (int i=0;i<4;i++)
        {
            if (nums[i]==0)
            {
                joke++;
            }
            else if (nums[i]==nums[i+1])
            {
                return false;
            }

        }
        //判断最大最小
        if (nums[4]-nums[joke]<5)
        {
            return true;
        }
        else
        {
            return false;
        }


    }


    //不排序做法
    public boolean isStraight2(int[] nums)
    {
        Set<Integer> set=new HashSet<>();
        int max=0;
        int min=14;
        for (int i=0;i<5;i++)
        {
            //如果为大小王
            if (nums[i]==0)
            {
                continue;
            }
            //最大最小
            max=Math.max(nums[i],max);
            min=Math.min(nums[i],min);
            //如果包含重复的，则返回
            if (set.contains(nums[i]))
            {
                return false;
            }
            set.add(nums[i]);
        }
        //
        if (max-min<5)
        {
            return true;
        }else
        {
            return false;
        }
    }
}
