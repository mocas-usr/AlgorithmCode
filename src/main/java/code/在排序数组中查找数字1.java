package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 下午4:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-13 16:18
 */
public class 在排序数组中查找数字1 {
    public int search(int[] nums, int target) {

        //查找左边界
        int left=0;
        int right=nums.length-1;
        boolean flag=false;//初始化未找到
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if (target>nums[mid])
            {
                left=mid+1;
            }else if (target<nums[mid])
            {
                right=mid-1;
            }else if (target==nums[mid])
            {
                flag=true;//说明存在数值
                right--;//注释，这里还可以是right=mid-1;
            }

        }
        //跳出循环时
        int len=0;
        if (flag)
        {
            for (int i=left;i<nums.length;i++)
            {
                if (nums[i]==target)
                {
                    len++;
                }else
                {
                    break;
                }
            }
            return len;
        }else
        {
            return len;
        }


    }

    @Test
    public void test()
    {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        search(nums,target);
    }
}
