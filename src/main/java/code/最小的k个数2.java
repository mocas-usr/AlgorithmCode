package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 下午8:23
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-09 20:23
 */
public class 最小的k个数2 {
    //快排序
    public int[] getLeastNumbers(int[] arr, int k) {

        quickSort(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);

    }

    public void quickSort(int[] nums,int left,int right,int key)
    {
        if (left>right)
        {
            return;
        }
        int stand=partion(nums,left,right);

        if (stand==key)
        {
            return;
        }else if (stand>key)
        {
            quickSort(nums,0,stand-1,key);
        }else if (stand<key)
        {
            quickSort(nums,stand+1,right,key);
        }
    }

    public int partion(int[] nums,int left,int right)
    {
        int index=left;
        int target=nums[left];

        while (left<right)
        {
            while (left<right&&nums[right]>=target)
            {
                right--;
            }
            while (left<right&&nums[left]<=target)
            {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }
        }
        swap(nums,left,index);
        return left;
    }

    public void swap(int[] nums,int left,int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

}
