package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 下午3:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-09 15:29
 */
public class 和为s的两个数字 {
    //二分查找
    public int[] twoSum(int[] nums, int target) {


        for (int i=0;i<target/2+1;i++)
        {
            int key=search(nums,target-nums[i],i+1,nums.length-1);
            if (key==-1)
            {
                continue;
            }else
            {
                return new int[]{nums[i],nums[key]};
            }
        }

        return new int[2];
    }

    //二分查找
    public int search(int[] nums,int key,int left,int right)
    {
        if (left>right)
        {
            return -1;
        }
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if (key<nums[mid])
            {
                right=mid-1;

            }else if (key>nums[mid])
            {
                left=mid+1;
            }else if (key==nums[mid])
            {
                return mid;
            }

        }
        return -1;
    }


    //碰撞双指针
    public int[] twoSum2(int[] nums, int target)
    {
       int left=0;
       int right=nums.length-1;
       while (left<right)
       {
           int s=nums[left]+nums[right];
           if (s>target)
           {
               right--;
           }else if (s<target)
           {
               left++;
           }else if (s==target)
           {
               return new int[]{nums[left],nums[right]};
           }
       }
       return new int[2];

    }


    @Test
    public void test()
    {
        int[] nums={2,7,11,15};
        int target=9;
        int[] ints=twoSum(nums,target);
    }
}
