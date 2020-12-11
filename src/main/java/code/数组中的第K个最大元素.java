package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/25 下午4:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.PriorityQueue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-25 16:27
 */
public class    数组中的第K个最大元素 {
    //堆实现
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue=new PriorityQueue<>(k);//排序堆，队首最小
        for (int i=0;i<nums.length;i++)
        {
            //如果队列里面还没有满，一直添加
            if (queue.size()<k)
            {
                queue.add(nums[i]);

            }
            else //如果满了，比较队首部
            {
                if (nums[i]>queue.peek())//是否大于队伍首部元素
                {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }

        int num=queue.peek();
        return num;

    }
    //快速排序
    public int findKthLargest2(int[] nums, int k)
    {
        //k-1就是第k大的元素
        quickSort(nums,0,nums.length-1,k-1);
        return nums[k-1];

    }

    public void quickSort(int[] nums,int left,int right,int k)
    {
        if (left<right)
        {
            int stand=partion(nums,left,right);
            if (stand==k)
            {
                return;
            }
            else if(stand<k)//说明右边没有排序结束
            {
                quickSort(nums,stand+1,right,k);
            }
            else if (stand>k)
            {
                quickSort(nums,left,stand-1,k);
            }
//            quickSort(nums,stand+1,right,k);
//            quickSort(nums,left,stand-1,k);
        }


    }

    public int partion(int[] nums,int left,int right)
    {

        int target=nums[left];
        int num=left;
        while (left<right)
        {
            while (nums[right]<=target &&left<right)
            {
                right--;
            }
            while (nums[left]>=target&&left<right)
            {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }
        }
        //此时排序结束
        swap(nums,num,left);
        return left;
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
        int[] arr={5,2,4,1,3,6,0};
        int k = 4;
        int num=findKthLargest2(arr,k);
        System.out.println(num);
    }
}
