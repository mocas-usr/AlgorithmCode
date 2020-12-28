package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/18 下午7:14
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import javax.swing.*;
import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-18 19:14
 */
public class 最长连续序列 {

    //排序
    public int longestConsecutive(int[] nums) {
        if (nums.length<2)
        {
            return nums.length;
        }
        Arrays.sort(nums);//排序
        int j=1;
        int maxLen=0;
        int len=1;
        int last=nums[0];//代表上一个数值
        //双指针
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==last)
            {
                //说明遇到重复元素了
                continue;
            }
            //说明递增序列
            if (nums[i]==last+1)
            {
                len++;
            }else
            {
                maxLen=Math.max(maxLen,len);
                len=1;
            }
            last=nums[i];

        }
        maxLen=Math.max(maxLen,len);
        return maxLen;

    }

    //集合
    public int longestConsecutive2(int[] nums)
    {
        if (nums.length == 0) return 0;
        //存储去重之后的数组
        Set<Integer> set=new HashSet<>();
        for (int num:nums)
        {
            set.add(num);
        }
        int current=0;
        int len=0;
        int maxLenth=0;

        //利用集合处理
        for (int num:nums)
        {
            //先从大到小查询有几个
            current=num;
            len=1;
            //如果向左搜索，如果包含有的
            while (set.contains(current-1))
            {
                //继续向左搜索
                current--;
            }
            //左边搜索到的长度
            len+=num-current;
            //向右搜索
            current=num;
            while (set.contains(current+1))
            {
                current++;
            }
            len+=(current-num);

            maxLenth=Math.max(maxLenth,len);

        }
        return maxLenth;
    }

    //hashmap
    public int longestConsecutive3(int[] nums)
    {
        //利用map存储左右边界
        Map<Integer,Integer> map=new HashMap<>();
        //[v,k]代表左右边界
        for (int num:nums)
        {
            map.put(num,num);
        }
        int len=0;
        int maxLen=0;
        for (int num:nums)
        {
            //
            int current=num;
            int right=0;

            //更新右边界
            //如果包含
            while (map.containsKey(current+1))
            {
                current++;
            }
            //更新右边界
            map.put(num,current);
            len=current-num+1;
            maxLen=Math.max(maxLen,len);

        }
        return maxLen;
    }

    @Test
    public void test()
    {
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        int res=longestConsecutive(nums);
    }
}
