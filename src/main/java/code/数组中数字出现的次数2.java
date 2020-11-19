package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/10 上午9:14
 * @email: wangyuhang_mocas@163.com
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-10 09:14
 */
public class 数组中数字出现的次数2 {
    public int singleNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        //双指针
        int i=0,j=1;

        while (i<nums.length &&j<nums.length)
        {
            if (nums[i]==nums[j])
            {
                j=j+1;

            }
            else if (j-i==1&&nums[i]!=nums[j] )
            {
                break;
            }
            else if (nums[i]!=nums[j] &&j-i>1)
            {
                //双指针移动
                i=j;
                j=i+1;
            }
        }
        return nums[i];


    }

    //双指针for
    public int singleNumber2(int[] nums)
    {
        Arrays.sort(nums);

        int index=0;
        for(int j=1;j<nums.length;j++)
        {
            //如果不相等，则满足条件
            if (nums[index]!=nums[j] &&j-index==1)
            {
                break;
            }else if (nums[index]!=nums[j]&&j-index>1)
            {
                //说明是个数大于1
                index=j;
            }else if (nums[j]==nums[index])
            {
                continue;
            }
        }
        return nums[index];
    }
}
