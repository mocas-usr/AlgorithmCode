package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午11:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 11:02
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {

        //查找左边界
        int left=0;
        int right=nums.length-1;
        int mid=0;
        int leftIndex=0;
        int rightIndex=0;
        Boolean flag=false;
        while (left<=right)
        {
            mid=left+(right-left)/2;
            if (target>nums[mid])
            {
                left=mid+1;
            }else if (target<nums[mid])
            {
                right=mid-1;
            }else if (target==nums[mid])
            {
                flag=true;
                right=mid-1;
            }
        }
        if (flag)
        {
            leftIndex=left;
        }else
        {
            return new int[]{-1,-1};
        }

        //找出右边界
        left=0;
        right=nums.length-1;
        while (left<=right)
        {
            mid=left+(right-left)/2;
            if (target<nums[mid])
            {
                right=mid-1;
            }else if (target>nums[mid])
            {
                left=mid+1;
            }else if (target==nums[mid])
            {
                left=mid+1;
            }
        }
        rightIndex=right;

        return new int[]{leftIndex,rightIndex};

    }

    @Test
    public void test()
    {
        int[] nums ={5,7,7,8,8,10};
        int target = 8;
        searchRange(nums,target);
    }

}
