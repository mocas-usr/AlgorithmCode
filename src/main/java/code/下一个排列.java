package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/28 下午3:52
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-28 15:52
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        if (nums.length==0)
        {
            return;
        }
        //寻找从小到大排序的段
        int n=nums.length;
        int i=n-1;
        //如果是从小到大排列，则一直滑动
        while (i>0 && nums[i-1]>=nums[i])
        {
            i--;
        }

        //找到排序的数值nums[i-1]<nums[i]
        int j=n-1;
        if (i==0)
        {
            reverse(nums,i,j);
            return;
        }
        while (j>0 && nums[j]<=nums[i-1])
        {
            j--;

        }
        //找到第一个大于的j，nums[j]>nums[i],交换
        int tmp=nums[j];
        nums[j]=nums[i-1];
        nums[i-1]=tmp;

        //交换之后反转i之后的数字
        int k=i;
        int t=n-1;
        reverse(nums,k,t);


    }

    //反转
    public void reverse(int[] nums,int k,int t)
    {
        while (k<t)
        {
            swap(nums,k,t);
            k++;
            t--;
        }
    }


    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    @Test
    public void test()
    {
        int[] nums={1,2,3};
        nextPermutation(nums);
    }
}
