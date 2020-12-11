package code.topK;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/25 上午10:52
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Enumeration;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-25 10:52
 */
public class 数组中的第K个最大元素 {
    //堆排序
    Queue<Integer> queue=new PriorityQueue<>();

    public int findKthLargest(int[] nums, int k) {

        //数组遍历
        for (int num:nums)
        {
            //如果堆队列小于k
            if (queue.size()<k)
            {
                queue.add(num);
            }else
            {
                //堆首元素小于num
                if (queue.peek()<num)
                {
                    queue.poll();
                    queue.add(num);
                }
            }

        }
        return queue.peek();
    }


    //快速排序
    public int findKthLargest2(int[] nums, int k)
    {
        quickSort(nums,0,nums.length-1,k-1);
        return nums[k-1];
    }

    //快排
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
        }
        else
        {
            quickSort(nums,left,stand-1,key);
            quickSort(nums,stand+1,right,key);
        }


    }

    //标准位寻找
    public int partion(int[] nums,int left,int right)
    {
            int one=left;
            int temp=nums[left];

            //left
            while (left<right)
            {
                while (left<right&&nums[right]<=temp)
                {
                    right--;
                }
                while (left<right&&nums[left]>=temp)
                {
                    left++;
                }
                if (left<right)
                {
                    swap(nums,left,right);
                }
            }

            //结束
            swap(nums,one,left);
            return left;
    }

    //交换
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }



}
