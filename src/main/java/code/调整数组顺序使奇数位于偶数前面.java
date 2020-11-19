package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:36
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 10:36
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        //冒泡
        //决定循环多少次
        for (int i=0;i<nums.length;i++)
        {
            //每一趟的排序
            for (int j=0;j<nums.length-1-i;j++)
            {
                //如果比他大
                if (compare(nums[j],nums[j+1]))
                {
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;

    }

    //快速排序
    public int[] exchange2(int[] nums)
    {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right)
    {
        if (left>right)
        {
            return;
        }
        int stand=partion(nums,left,right);
        quickSort(nums,left,stand-1);
        quickSort(nums,stand+1,right);
    }

    public int partion(int[] nums,int left,int right)
    {
        int temp=left;
        int key=nums[left];
        while (left<right)
        {
            while (left<right&&compare(nums[right],key))
            {
                right--;
            }
            while (left<right&&compare(key,nums[left]))
            {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }
        }
        swap(nums,left,temp);
        return left;
    }

    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //比较奇偶数
    public Boolean compare(int num1,int num2)
    {
        //如果都是奇数或者偶数，则相等，不大于
        if ((num1&1)==(num2&1))
        {
            return num1-num2>0;
        }
        else if ((num1&1)==1 && (num2&1)==0)
        {
            //奇数比偶数小
            return false;
        }
        else if ((num1&1)==0 && (num2&1)==1)
        {
            return true;
        }
        return false;
    }

    //双指针快排
    public int[] exchange3(int[] nums)
    {
        int left=0;
        int right=nums.length-1;

        while (left<right)
        {
            //如果是偶数
            while (left<right&&nums[right]%2!=1)
            {
                right--;
            }
            while (left<right&&nums[left]%2==1)
            {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }
        }
        return nums;
    }

    @Test
    public void test()
    {
        int[] nums={2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        exchange2(nums);

    }
}
