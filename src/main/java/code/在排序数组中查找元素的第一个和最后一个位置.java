package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/28 上午10:05
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-28 10:05
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        //特殊情况处理
        int[] pre = {-1, -1};
        if (nums.length == 0) {
            return pre;
        }
        if (nums.length == 1)
        {
            if (target==nums[0])
            {
                return new int[]{0,0};
            }
            else
            {
                return pre;
            }
        }

        int firstPositon=findFirstPosition(nums,target);
        if (firstPositon==-1)
        {
            return pre;
        }
        int lastPosition=findLastPosition(nums,target);
        int[] res=new int[]{firstPositon,lastPosition};
        return res;

    }


    //寻找第一个出现位置
    public int findFirstPosition(int[] nums,int target)
    {
        int n=nums.length;

        int left=0;
        int right=n-1;
        int mid=0;
        while (left<=right)
        {

            mid=left+(right-left)/2;
            if (nums[mid]==target)
            {
                right=mid-1;//如果相等，则不断向左边缩进
            }
            else if (target>nums[mid])
            {
                left=mid+1;
            }
            else if (target<nums[mid])
            {
                right=mid-1;
            }

        }
        //left>right 时跳出循环，，三种情况
        //说明没找到，target>所有
        if (left>n-1)
        {
            return -1;
        }

        //跳出循环时，
        if (nums[left]==target)
        {
            return left;
        }
        return -1;
    }

    //寻找右边截止位置
    public int findLastPosition(int[] nums,int target)
    {
        int n=nums.length;

        int left=0;
        int right=n-1;
        int mid=0;
        while (left<=right)
        {

            mid=left+(right-left)/2;
            if (nums[mid]==target)
            {
                left=mid+1;//如果相等，则不断向右边缩进
            }
            else if (target>nums[mid])
            {
                left=mid+1;
            }
            else if (target<nums[mid])
            {
                right=mid-1;
            }

        }
        //left>right 时跳出循环，，三种情况
        //说明没找到，target>所有
        if (right<0)
        {
            return -1;
        }
        //跳出循环时，
        if (nums[right]==target)
        {
            return right;
        }
        return -1;
    }

    @Test
    public void test()
    {
        int[] nums={2,2};
        searchRange(nums,2);
    }
}
